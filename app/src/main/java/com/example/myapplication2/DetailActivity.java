package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.myapplication2.Index", -1);
        if(index > -1){
            int pic = getImg(index);
            ImageView img = findViewById(R.id.imageView);
            scaleImg(img,pic);
        }
    }

    private int getImg(int index){
        switch (index){
            case 0: return R.drawable.example1;
            case 1 : return R.drawable.example2;
            case 2 : return R.drawable.example3;
            default: return -1;
        }
    }
    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),pic,options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int raito = Math.round( (float)imgWidth/(float) screenWidth);
            options.inSampleSize = raito;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic,options);
        img.setImageBitmap(scaledImg);
    }
}