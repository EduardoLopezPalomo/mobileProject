package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText name = findViewById(R.id.nameText);
        EditText passwordtext = findViewById(R.id.PasswordText);
        Button login = findViewById(R.id.loginButton);

        username =name.getText().toString();
        password = passwordtext.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(getApplicationContext(), SecondActivity.class );
                startActivity(loginIntent);
            }
        });
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}