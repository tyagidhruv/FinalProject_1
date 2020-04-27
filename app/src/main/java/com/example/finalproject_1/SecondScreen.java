package com.example.finalproject_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_second);
        EditText imageSource = findViewById(R.id.imageSource);
        imageSource.setInputType(InputType.TYPE_CLASS_TEXT);
        Button enterURL = findViewById(R.id.enterURL);
        enterURL.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }
}