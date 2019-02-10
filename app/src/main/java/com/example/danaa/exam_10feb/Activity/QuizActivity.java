package com.example.danaa.exam_10feb.Activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danaa.exam_10feb.Model.Question;
import com.example.danaa.exam_10feb.Model.Quiz;
import com.example.danaa.exam_10feb.R;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView questionView;
    EditText answerText;
    Button nextButton;
    List<Question> questions;
    Integer currentQuestion = 0;
    Quiz quiz;
    Question questionToShow;
    TextView textTimer;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionView = findViewById(R.id.question);
        answerText = findViewById(R.id.answer);
        nextButton = findViewById(R.id.next);
        textTimer = findViewById(R.id.timer);

        Bundle bundle = getIntent().getExtras();
        Question question1 = (Question) bundle.getSerializable("question1");
        Question question2 = (Question) bundle.getSerializable("question2");

        questions = new ArrayList<>();

        quiz = new Quiz();

        questions.add(question1);
        questions.add(question2);

        questionToShow = questions.get(currentQuestion); // SETEZ PRIMA INTREBARE
        questionView.setText(questionToShow.getText());

        countDownTimer = new CountDownTimer(6000, 100) {

            public void onTick(long millisUntilFinished) {
                long time = millisUntilFinished / 1000;
                textTimer.setText(String.valueOf(time));
            }

            public void onFinish() {
                nextButton();
            }

        };
        countDownTimer.start();

        nextButton.setOnClickListener(v -> {//CAND DA CLICK
            countDownTimer.cancel();
            nextButton();
        });

    }

    private void nextButton() {

        addToQuiz(questionToShow.getId(), answerText.getText().toString()); //salvez raspunsul curent
        currentQuestion++;                                                 //trec la urmatoarea intrebare
        nextButtonHandler(currentQuestion);
    }

    private void addToQuiz(Integer id, String answer) {
        quiz.add(id, answer);
    }

    private void nextButtonHandler(Integer questionNumber) {


        if (currentQuestion < questions.size()) { //daca mai am intrebari

            questionToShow = questions.get(questionNumber);
            questionView.setText(questionToShow.getText());//SETEZ TEXTUL

            countDownTimer.start();
        }
        else{
            nextButton.setEnabled(false);
            ///start new activity
        }
    }
}
