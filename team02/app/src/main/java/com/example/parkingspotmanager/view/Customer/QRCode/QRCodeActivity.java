package com.example.parkingspotmanager.view.Customer.QRCode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.parkingspotmanager.R;
import com.example.parkingspotmanager.domain.Customer;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The QRCodeActivity class represents the activity for generating and displaying a QR code
 * for a customer. The QR code contains customer information and can be saved to internal storage.
 */
public class QRCodeActivity extends AppCompatActivity implements QRCodeView {

    private QRCodeViewModel viewModel;
    private static final String CUSTOMER_USERNAME_EXTRA = "customer_username_extra";
    private String customerUsername;
    private Customer customer;

    /**
     * Initializes the activity, sets up the layout, and retrieves customer information.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        customerUsername = getIntent().getStringExtra(CUSTOMER_USERNAME_EXTRA);

        viewModel = new ViewModelProvider(this).get(QRCodeViewModel.class);
        viewModel.getPresenter().setView(this);
        viewModel.getPresenter().findCustomerInfo(customerUsername);

        customer = viewModel.getPresenter().getCustomer();
        viewModel.getPresenter().createQRCode(customer, customerUsername);
    }

    /**
     * Displays the generated QR code in an ImageView.
     *
     * @param qrCodeImage The Bitmap containing the QR code image.
     */
    @Override
    public void setQRCode(Bitmap qrCodeImage) {
        ImageView imgQRCode = findViewById(R.id.imgQRCode);
        imgQRCode.setImageBitmap(qrCodeImage);
    }

    /**
     * Generates a QR code from the provided data and saves it to internal storage.
     *
     * @param data     The data to be encoded in the QR code.
     * @param username The username used to name the saved QR code file.
     * @param width    The width of the QR code image.
     * @param height   The height of the QR code image.
     */
    @Override
    public void generateQRCode(Object data, String username, int width, int height) {
        try {
            Gson gson = Converters.registerLocalDateTime(new GsonBuilder()).create();
            String dataString = gson.toJson(data);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(dataString, BarcodeFormat.QR_CODE, width, height);

            // Convert BitMatrix to Bitmap
            Bitmap qrCodeBitmap = toBitmap(bitMatrix);
            setQRCode(qrCodeBitmap); // Display the QR code

            // Save QR Code to internal storage
            String fileName = username + ".png";
            saveQRCode(qrCodeBitmap, fileName);

        } catch (WriterException e) {
            Toast.makeText(this, "Error generating QR Code: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Converts a BitMatrix to a Bitmap.
     *
     * @param bitMatrix The BitMatrix to convert.
     * @return The resulting Bitmap.
     */
    private Bitmap toBitmap(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bitmap.setPixel(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return bitmap;
    }

    /**
     * Saves the QR code Bitmap to internal storage.
     *
     * @param bitmap   The Bitmap to save.
     * @param fileName The name of the file to save the Bitmap as.
     */
    private void saveQRCode(Bitmap bitmap, String fileName) {
        // Create the qrcodes directory if it doesn't exist
        File qrcodesDir = new File(getFilesDir(), "qrcodes");
        if (!qrcodesDir.exists()) {
            qrcodesDir.mkdirs(); // Create the directory and any necessary parent directories
        }

        // Create the file in the qrcodes directory
        File file = new File(qrcodesDir, fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            Toast.makeText(this, "QR Code saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            Log.d("QRCodeActivity", "File saved at: " + file.getAbsolutePath());
        } catch (IOException e) {
            Toast.makeText(this, "Error saving QR Code: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Retrieves a QR code Bitmap from internal storage.
     *
     * @param fileName The name of the file containing the QR code.
     * @return The Bitmap if the file exists, otherwise null.
     */
    @Override
    public Bitmap getQRCode(String fileName) {
        // Construct the full file path including the qrcodes directory
        File qrcodesDir = new File(getFilesDir(), "qrcodes");
        File imgFile = new File(qrcodesDir, fileName);

        // Check if the file exists and return the decoded Bitmap
        if (imgFile.exists()) {
            return BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        } else {
            Log.e("QRCodeActivity", "File not found: " + imgFile.getAbsolutePath());
            return null;
        }
    }
}