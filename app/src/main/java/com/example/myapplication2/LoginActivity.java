package com.example.myapplication2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static String username;
    private static String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText name = findViewById(R.id.nameText);
        EditText passwordtext = findViewById(R.id.PasswordText);
        Button login = findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUsername(name.getText().toString());
                setPassword(passwordtext.getText().toString());
                if(username.isEmpty()){
                    TextView error = findViewById(R.id.errorLoginTextView);
                    error.setText("The username can not be empty");
                }else if(password.isEmpty()){
                    TextView error = findViewById(R.id.errorLoginTextView);
                    error.setText("The password can not be empty");
                }else {
                    Intent loginIntent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(loginIntent);
                }
            }
        });
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

    public static void setPassword(String password) {
        LoginActivity.password = password;
    }

    public static void setUsername(String username) {
        LoginActivity.username = username;
    }
}