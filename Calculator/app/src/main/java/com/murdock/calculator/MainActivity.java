package com.murdock.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView inputText, outputText;

    private String input, output, newOutput;

    private Button zero, one, two, three, four, five, six, seven,
            eight, nine, add, mul, sub, div, dot, mod,
            power, equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input);
        outputText = findViewById(R.id.output);

        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        add = findViewById(R.id.add);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        sub = findViewById(R.id.sub);
        dot = findViewById(R.id.dot);
        power = findViewById(R.id.power);
        equal = findViewById(R.id.equal);
        mod = findViewById(R.id.mod);
        clear = findViewById(R.id.clear);

    }

    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = null;
                output=null;
                newOutput=null;
                outputText.setText("");
                break;

            case "^":
                solve();
                input += "^";
                break;

            case "×":
                solve();
                input += "×";
                break;

            case "=":
                solve();
                break;

            case "÷":
                input += "÷";
                double d = Double.parseDouble(inputText.getText().toString()) / 100;
                outputText.setText(String.valueOf(d));
                break;

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("÷") || data.equals("−")) {
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
            }catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("×").length == 2) {
            String numbers[] = input.split("×");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("÷").length == 2) {
            String numbers[] = input.split("÷");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }

        if (input.split("%").length == 2) {
            String numbers[] = input.split("%");
            try {
                double d = Double.parseDouble(numbers[0]) % Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }

        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }

        if (input.split("\\−").length == 2) {
            String numbers[] = input.split("\\−");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText("-" + newOutput);
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                }
            }catch (Exception e){
                outputText.setText(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}