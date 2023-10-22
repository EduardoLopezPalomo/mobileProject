package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        RatingBar r = findViewById(R.id.ratingBar);
        r.setIsIndicator(true);

        TextView texto = findViewById(R.id.usernameTextView);
        texto.setText(LoginActivity.getUsername());

    }
}