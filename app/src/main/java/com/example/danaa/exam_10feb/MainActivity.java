package com.example.danaa.exam_10feb;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.danaa.exam_10feb.Activity.QuizActivity;
import com.example.danaa.exam_10feb.Model.Question;
import com.example.danaa.exam_10feb.Remote.DataClient;
import com.example.danaa.exam_10feb.Remote.RetrofitUtils;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    DataClient dataClient;
    List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataClient = RetrofitUtils.getRetrofit().create(DataClient.class);

        startButton = findViewById(R.id.startButton);
        startButton.setEnabled(false);
        onStartApp();
        startButton.setOnClickListener(v -> startQuiz());


    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void onStartApp(){
        if(isNetworkConnected()){
            Call<List<Question>> call = dataClient.getQuestions();

            call.enqueue(new Callback<List<Question>>() {
                @Override
                public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
                        startButton.setEnabled(true);
                        int size = response.body().size();
                        questions = response.body().subList(0,size-1);

                    }else{
                        Toast.makeText(MainActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Question>> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(MainActivity.this,"No connection",Toast.LENGTH_SHORT).show();
        }
    }
    public void startQuiz(){
            Intent intent = new Intent(MainActivity.this,QuizActivity.class);

            Random random = new Random();

            Question question1 = questions.get(random.nextInt(1000));
            Question question2 = questions.get(random.nextInt(1000));
            intent.putExtra("question1", question1);
            intent.putExtra("question2", question2);

            startActivity(intent);
    }

}
