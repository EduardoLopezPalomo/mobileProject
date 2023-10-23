package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        RatingBar r = findViewById(R.id.ratingBar);
        Switch theme = findViewById(R.id.themeSwitch);
        Switch passwordSwitch = findViewById(R.id.passwordSwitch);
        Switch valoration = findViewById(R.id.valorationSwitch);
        r.setIsIndicator(true);

        TextView numberValoration = findViewById(R.id.textView);
        TextView texto = findViewById(R.id.usernameTextView);
        TextView password = findViewById(R.id.passwordTextView);
        texto.setText(LoginActivity.getUsername());
        password.setText(LoginActivity.getPassword());

        password.setVisibility(View.INVISIBLE);
        r.setVisibility(View.INVISIBLE);
        numberValoration.setVisibility(View.INVISIBLE);


        int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        theme.setChecked(currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES);

        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                recreate();
            }
        });

        valoration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    r.setVisibility(View.VISIBLE);
                    numberValoration.setVisibility(View.VISIBLE);
                    ChangeColor.changeColorRating(getResources(),r);
                }else{
                    r.setVisibility(View.INVISIBLE);
                    numberValoration.setVisibility(View.INVISIBLE);
                }
            }
        });
        passwordSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    password.setVisibility(View.VISIBLE);
                }else{
                    password.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}