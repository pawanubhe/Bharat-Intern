package com.murdock.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    TextView qno, question;
    Button op1, op2, op3, op4, submit;
    int sub;
    String select = "";
    int current = 0;
    int score = 0;
    int total = Quiz1.questions.length;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = findViewById(R.id.questionTV);
        qno = findViewById(R.id.queNumber);
        op1 = findViewById(R.id.answer1);
        op1.setOnClickListener(this);
        op2 = findViewById(R.id.answer2);
        op2.setOnClickListener(this);
        op3 = findViewById(R.id.answer3);
        op3.setOnClickListener(this);
        op4 = findViewById(R.id.answer4);
        op4.setOnClickListener(this);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);
        sub = getIntent().getIntExtra("sub", 0);

        newQuestion();

}
    public void newQuestion()
    {
        if (current == total)
        {
            endQuiz();
            return;
        }

        qno.setText(current + 1 +"/" + total);

        if(sub == 1)
        {
            question.setText(Quiz1.questions[current]);
            op1.setText(Quiz1.options[current][0]);
            op2.setText(Quiz1.options[current][1]);
            op3.setText(Quiz1.options[current][2]);
            op4.setText(Quiz1.options[current][3]);
        }

        else if(sub == 2)
        {
            question.setText(Quiz2.questions[current]);
            op1.setText(Quiz2.options[current][0]);
            op2.setText(Quiz2.options[current][1]);
            op3.setText(Quiz2.options[current][2]);
            op4.setText(Quiz2.options[current][3]);
        }

        else if(sub == 3)
        {
            question.setText(Quiz3.questions[current]);
            op1.setText(Quiz3.options[current][0]);
            op2.setText(Quiz3.options[current][1]);
            op3.setText(Quiz3.options[current][2]);
            op4.setText(Quiz3.options[current][3]);
        }

        else if(sub == 4)
        {
            question.setText(Quiz4.questions[current]);
            op1.setText(Quiz4.options[current][0]);
            op2.setText(Quiz4.options[current][1]);
            op3.setText(Quiz4.options[current][2]);
            op4.setText(Quiz4.options[current][3]);
        }

    }

    private void endQuiz()
    {
        String result = "";
        if(score > total*0.60){
            new AlertDialog.Builder(this)
                    .setTitle("Passed")
                    .setMessage("Your score is " + score + " out of " + total)
                    .setNegativeButton("Okay", (dialogInterface, i) -> quitQuiz())
                    .setCancelable(false).setIcon(R.drawable.passed)
                    .show();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Failed")
                    .setMessage("Your score is " + score + " out of " + total)
                    .setNegativeButton("Okay", (dialogInterface, i) -> quitQuiz())
                    .setCancelable(false).setIcon(R.drawable.failed)
                    .show();
        }
    }

    private void quitQuiz()
    {
        Intent intent = new Intent(QuizActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        op1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));
        op2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));
        op3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));
        op4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));

        op1.setTextColor(getResources().getColor(R.color.black));
        op2.setTextColor(getResources().getColor(R.color.black));
        op3.setTextColor(getResources().getColor(R.color.black));
        op4.setTextColor(getResources().getColor(R.color.black));

        Button clicked = (Button) view;
        if(clicked.getId() == R.id.submit && sub == 1)
        {
            if(select.equals(Quiz1.answers[current]))
            {
                score++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            current++;
            newQuestion();
        }
        else if (clicked.getId() == R.id.submit && sub == 2) {
            if(select.equals(Quiz2.answers[current]))
            {
                score++;
            }
            current++;
            newQuestion();
        }
        else if (clicked.getId() == R.id.submit && sub == 3) {
            if(select.equals(Quiz3.answers[current]))
            {
                score++;
            }
            current++;
            newQuestion();
        }
        else if (clicked.getId() == R.id.submit && sub == 4) {
            if(select.equals(Quiz4.answers[current]))
            {
                score++;
            }
            current++;
            newQuestion();
        }
        else{
            select  = clicked.getText().toString();
            clicked.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
            clicked.setTextColor(getResources().getColor(R.color.black));
        }
    }
}