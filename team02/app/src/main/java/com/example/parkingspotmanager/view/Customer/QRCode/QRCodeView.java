package com.example.parkingspotmanager.view.Customer.QRCode;

import com.example.parkingspotmanager.domain.Customer;
import android.graphics.Bitmap;

/**
 * The QRCodeView interface defines the contract for the view that displays and manages QR codes.
 * It provides methods for setting, retrieving, and generating QR codes.
 */
public interface QRCodeView {

    /**
     * Sets the QR code image to be displayed in the view.
     *
     * @param qrCodeImage The Bitmap containing the QR code image.
     */
    void setQRCode(Bitmap qrCodeImage);

    /**
     * Retrieves a QR code image from the specified file path.
     *
     * @param path The file path where the QR code image is stored.
     * @return The Bitmap containing the QR code image, or null if the file does not exist.
     */
    Bitmap getQRCode(String path);

    /**
     * Generates a QR code from the provided data and saves it to the file system.
     *
     * @param data     The data to be encoded in the QR code.
     * @param username The username used to name the saved QR code file.
     * @param width    The width of the QR code image.
     * @param height   The height of the QR code image.
     */
    void generateQRCode(Object data, String username, int width, int height);
}