package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        String item = in.getStringExtra("com.example.myapplication2.Item");
        int pic = getImg(item);
        ImageView img = findViewById(R.id.imageView);
        scaleImg(img,pic);

    }

    private int getImg(String item){
        switch (item){
            case "peach": return R.drawable.peach;
            case "tomato": return R.drawable.tomato;
            case "apple": return R.drawable.apple;
            case "banana": return R.drawable.banana;
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