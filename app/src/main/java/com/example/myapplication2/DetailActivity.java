package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        String item = in.getStringExtra("com.example.myapplication2.Item");
        String price = in.getStringExtra("com.example.myapplication2.Price");
        String desc = in.getStringExtra("com.example.myapplication2.Desc");

        int pic = getImg(item);
        ImageView img = findViewById(R.id.imageView);
        TextView itemText = findViewById(R.id.itemTextView);
        TextView priceText = findViewById(R.id.costTextView);
        TextView descText = findViewById(R.id.descriptionText);
        TextView buyer = findViewById(R.id.buyerTextView);
        TextView infoText = findViewById(R.id.infoTextView);
        Switch info = findViewById(R.id.seeInfoSwitch);
        TextView valoration = findViewById(R.id.ratingTextView);
        RatingBar ratingBar = findViewById(R.id.buyerRatingBar);


        buyer.append(getBuyer(item));
        infoText.setText("name: " + getBuyer(item)+ "\nDate of birth: 14/11/1995\nGender: Male\nLocation: Earth");
        valoration.setText("valoration:");
        infoText.setVisibility(View.INVISIBLE);
        valoration.setVisibility(View.INVISIBLE);
        ratingBar.setVisibility(View.INVISIBLE);

        itemText.setText(item);
        priceText.setText(price);
        descText.setText(desc);
        scaleImg(img,pic);

        info.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    infoText.setVisibility(View.VISIBLE);
                    valoration.setVisibility(View.VISIBLE);
                    ratingBar.setVisibility(View.VISIBLE);
                    ChangeColor.changeColorRating(getResources(),ratingBar);
                }else{
                    infoText.setVisibility(View.INVISIBLE);
                    valoration.setVisibility(View.INVISIBLE);
                    ratingBar.setVisibility(View.INVISIBLE);
                }
            }
        });
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
    private String getBuyer(String item){
        switch (item){
            case "peach": return "Kanan";
            case "tomato": return "Kobe";
            case "apple": return "Mario";
            case "banana": return "Aragorn";
            default: return "";
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