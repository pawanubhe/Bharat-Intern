package com.murdock.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView convertRV;
    UnitRecyclerAdapter unitRecyclerAdapter;
    Toolbar toolbar;
    TextView textHeading;

    int[] convertList = {R.drawable.ctof,R.drawable.ctok,R.drawable.ftoc,R.drawable.ftok,R.drawable.ktoc,R.drawable.ktof};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertRV = findViewById(R.id.convertRV);
        toolbar = findViewById(R.id.toolbar);
        textHeading = findViewById(R.id.textHeading);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Temperature Converter");

        unitRecyclerAdapter = new UnitRecyclerAdapter(this, convertList);
        convertRV.setAdapter(unitRecyclerAdapter);
        convertRV.setLayoutManager(new GridLayoutManager(this, 2));
    }

}