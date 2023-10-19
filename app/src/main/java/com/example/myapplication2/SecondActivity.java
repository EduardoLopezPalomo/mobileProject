package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent().hasExtra("id1")){
            TextView text = findViewById(R.id.ExampleText);
            String aux = getIntent().getExtras().getString("id1");
            text.setText(aux);
        }

        Button googleBtn = findViewById(R.id.GoogleButton);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "https://www.google.com/";
                Uri address = Uri.parse(google);

                Intent goGoogle = new Intent(Intent.ACTION_VIEW, address);
                if(goGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(goGoogle);
                }else{
                    TextView aux = findViewById(R.id.ExampleText);
                    aux.setText("fallo");
                }
            }
        });
    }
}