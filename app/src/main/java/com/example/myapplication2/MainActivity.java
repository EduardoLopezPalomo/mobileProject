package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = findViewById(R.id.AddButton);
        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1 = findViewById(R.id.NameEditText);
                EditText num2 = findViewById(R.id.NameEditText2);
                TextView textResult = findViewById(R.id.ResultTextView);

                int number1 = Integer.parseInt(num1.getText().toString());
                int number2 = Integer.parseInt(num2.getText().toString());
                int result = number1 +number2;

                textResult.setText(result+ "");
            }
        });
    }
}