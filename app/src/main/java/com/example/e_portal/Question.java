package com.example.e_portal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Question extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton btndone;
    private Timer quizTimer;
    private int totalTimeInMins = 1;
    private int seconds = 0;
    private List<QuestionsList> questionsLists;
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final ImageView btn_back = findViewById(R.id.btn_back);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedtopicname = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        btndone = findViewById(R.id.btndone);

        final String getselectedtopicname = getIntent().getStringExtra("selectedtopic");

        selectedtopicname.setText(getselectedtopicname);
        questionsLists = QuestionsBank.getQuestions(getselectedtopicname);
        startTimer(timer);

        questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.redbox_10corner);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option2.setBackgroundResource(R.drawable.redbox_10corner);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option3.setBackgroundResource(R.drawable.redbox_10corner);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option4.setBackgroundResource(R.drawable.redbox_10corner);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(Question.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(Question.this, MainActivity.class));
                finish();
            }
        });

    }

    private void changeNextQuestion(){
        currentQuestionPosition++;
        if((currentQuestionPosition)<questionsLists.size()){
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.white_10corner);
            option1.setTextColor(Color.parseColor("#000000"));

            option2.setBackgroundResource(R.drawable.white_10corner);
            option2.setTextColor(Color.parseColor("#000000"));

            option3.setBackgroundResource(R.drawable.white_10corner);
            option3.setTextColor(Color.parseColor("#000000"));

            option4.setBackgroundResource(R.drawable.white_10corner);
            option4.setTextColor(Color.parseColor("#000000"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        }
        else{
            Intent intent = new Intent(Question.this, MainActivity.class);
            intent.putExtra("correct", getCorrectAnswer());
            intent.putExtra("incorrect", getInCorrectAnswer());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timertextView){
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds==0){
                    totalTimeInMins --;
                    seconds=59;
                }
                else if(seconds == 0 && totalTimeInMins == 0){
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(Question.this, "Time Over", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Question.this, MainActivity.class);
                    intent.putExtra("correct", getCorrectAnswer());
                    intent.putExtra("incorrect", getInCorrectAnswer());
                    startActivity(intent);

                    finish();
                }

                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalTimeInMins);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length()==1){
                            finalMinutes="0"+finalMinutes;
                        }

                        if(finalSeconds.length()==1){
                            finalSeconds="0"+finalSeconds;
                        }

                        timertextView.setText(finalMinutes+":"+finalSeconds);

                    }
                });

            }
        }, 1000, 1000);
    }
    private int getCorrectAnswer(){
        int correctAnswers = 0;

        for(int i=0; i<questionsLists.size(); i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    private int getInCorrectAnswer(){
        int correctAnswers = 0;

        for(int i=0; i<questionsLists.size(); i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(Question.this, MainActivity.class));
        finish();
    }
    private void revealAnswer(){
        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.green_10corner);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.green_10corner);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.green_10corner);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.green_10corner);
            option4.setTextColor(Color.WHITE);
        }

    }
}