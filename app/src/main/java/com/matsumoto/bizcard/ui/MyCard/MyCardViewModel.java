package com.matsumoto.bizcard.ui.MyCard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.matsumoto.bizcard.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyCardViewModel extends ViewModel {
    private ImageView my_qr;
    private final String my_qr_file_name = "myQR.jpg";

    void setMyQrImage(@NonNull View view){
        my_qr = view.findViewById(R.id.my_qr);

        try{
            File srcFile = new File(my_qr_file_name);
            FileInputStream fis = new FileInputStream(srcFile);
            Bitmap bm = BitmapFactory.decodeStream(fis);
            my_qr.setImageBitmap(bm);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean isExistQRImage(){

        File file = new File(my_qr_file_name);
        return file.exists();
    }

    public void saveQRcode(){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 400, 400);
            File root_dir = Environment.getExternalStorageDirectory();
            FileOutputStream out = new FileOutputStream(new File(root_dir, my_qr_file_name + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
