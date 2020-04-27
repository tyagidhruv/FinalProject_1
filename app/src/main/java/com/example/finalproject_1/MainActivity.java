package com.example.finalproject_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterImage = findViewById(R.id.enterImage);
        enterImage.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondScreen.class));
            finish();
        });
    }
}
