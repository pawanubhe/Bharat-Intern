package com.murdock.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button android, os, html, gk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android = findViewById(R.id.btnAndroid);
        os = findViewById(R.id.btnOs);
        html = findViewById(R.id.btnHtml);
        gk = findViewById(R.id.btnGen);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz(1);
            }
        });

        os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz(2);
            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz(3);
            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz(4);
            }
        });
    }

    public void quiz(int i){
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("sub",i);
        startActivity(intent);
    }
}