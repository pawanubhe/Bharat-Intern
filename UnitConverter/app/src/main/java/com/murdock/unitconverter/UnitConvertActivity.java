package com.murdock.unitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UnitConvertActivity extends AppCompatActivity {

    TextView text1, text2, textRes;
    Button buttonConvert;
    EditText editTemp;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_convert);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        textRes = findViewById(R.id.textRes);
        buttonConvert = findViewById(R.id.buttonConvert);
        editTemp = findViewById(R.id.editTemp);
        toolBar = findViewById(R.id.toolBar);

        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Unit unit = (Unit) intent.getSerializableExtra("unit");
        text1.setText(unit.unit1);
        text2.setText(unit.unit2);

        //Celsius to Fahrenheit
        if (unit.unit1.equals("Celsius") && unit.unit2.equals("Fahrenheit"))
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double c = Double.valueOf(editTemp.getText().toString());
                    Double f = (c * 9/5) + 32;
                    textRes.setText(String.valueOf(f));
                }
            });
        }
        //Celsius to Kelvin
        else if (unit.unit1.equals("Celsius") && unit.unit2.equals("Kelvin"))
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double c = Double.valueOf(editTemp.getText().toString());
                    Double k = c + 273.15;
                    textRes.setText(String.valueOf(k));
                }
            });
        }
        //Fahrenheit to Celsius
        else if (unit.unit1.equals("Fahrenheit") && unit.unit2.equals("Celsius"))
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double f = Double.valueOf(editTemp.getText().toString());
                    Double c = (f - 32) * 5/9;
                    textRes.setText(String.valueOf(c));
                }
            });
        }
        //Fahrenheit to Kelvin
        else if (unit.unit1.equals("Fahrenheit") && unit.unit2.equals("Kelvin"))
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double f = Double.valueOf(editTemp.getText().toString());
                    Double k =  (f - 32) * 5 / 9 + 273.15;
                    textRes.setText(String.valueOf(k));
                }
            });
        }
        //Kelvin to Celsius
        else if (unit.unit1.equals("Kelvin") && unit.unit2.equals("Celsius"))
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double k = Double.valueOf(editTemp.getText().toString());
                    Double c =  k - 273.15;
                    textRes.setText(String.valueOf(c));
                }
            });
        }
        //Kelvin to Fahrenheit
        else
        {
            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Double k = Double.valueOf(editTemp.getText().toString());
                    Double f = (k - 273.15) * 9/5 + 32;
                    textRes.setText(String.valueOf(f));
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}