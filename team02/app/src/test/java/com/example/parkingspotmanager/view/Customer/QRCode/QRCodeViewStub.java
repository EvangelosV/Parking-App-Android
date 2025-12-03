package com.example.parkingspotmanager.view.Customer.QRCode;

import android.graphics.Bitmap;

public class QRCodeViewStub implements QRCodeView {
    boolean onBitmap = false;

    @Override
    public void setQRCode(Bitmap qrCode) {
        onBitmap = true;
    }

    @Override
    public Bitmap getQRCode(String fileName) {
        onBitmap = true;
        return null;
    }

    @Override
    public void generateQRCode(Object data, String username, int width, int height) {
        onBitmap = true;
    }
}