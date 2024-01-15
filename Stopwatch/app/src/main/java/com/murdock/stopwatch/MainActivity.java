package com.murdock.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean running;
    private Chronometer chronometer;
    private long pauseoffset;
    Button start, pause, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btnStart);
        pause = findViewById(R.id.btnPause);
        reset = findViewById(R.id.btnStop);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("%s");
        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
//            @Override
//            public void onChronometerTick(Chronometer chronometer) {
//                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000){
//                    chronometer.setBase(SystemClock.elapsedRealtime());
//                    Toast.makeText(MainActivity.this, "Time's Up!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    chronometer.setBase(SystemClock.elapsedRealtime()- pauseoffset);
                    chronometer.start();
                    running = true;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(running){
                    chronometer.stop();
                    pauseoffset = SystemClock.elapsedRealtime()- chronometer.getBase();
                    running = false;
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseoffset = 0;
            }
        });
    }
}