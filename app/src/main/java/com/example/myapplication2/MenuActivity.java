package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button amazon = findViewById(R.id.AmazonButton);
        Button product = findViewById(R.id.ProductsButton);
        Button profile = findViewById(R.id.Profilebutton);

        amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amazonweb = "https://www.amazon.com/";
                Uri link = Uri.parse(amazonweb);
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                if(i.resolveActivity(getPackageManager()) != null){
                    startActivity(i);
                }else {
                    TextView error = findViewById(R.id.errorTextView);
                    error.setText("we can´t go to amazon.com");
                }
            }
        });
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class );
                startActivity(i);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class );
                startActivity(i);
            }
        });
    }
}