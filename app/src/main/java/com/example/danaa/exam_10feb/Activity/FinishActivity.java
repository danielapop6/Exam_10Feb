package com.example.danaa.exam_10feb.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danaa.exam_10feb.Model.Quiz;
import com.example.danaa.exam_10feb.R;
import com.example.danaa.exam_10feb.Remote.DataClient;
import com.example.danaa.exam_10feb.Remote.MyResponse;
import com.example.danaa.exam_10feb.Remote.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinishActivity extends AppCompatActivity {

    TextView score;
    Quiz quiz;
    DataClient dataClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        score = findViewById(R.id.score);

        dataClient = RetrofitUtils.getRetrofit().create(DataClient.class);

        Bundle bundle = getIntent().getExtras();
        quiz = (Quiz) bundle.getSerializable("quiz");

        sendQuiz();

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    private void sendQuiz() {
        if (isNetworkConnected()) {
            Call<MyResponse> call = dataClient.sendQuiz(quiz.getAnswers());
            call.enqueue(new Callback<MyResponse>() {
                @Override
                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                    if (response.isSuccessful()) {
                        score.setText(response.body().getCount().toString());
                    } else {
                        Toast.makeText(FinishActivity.this,"Unsuccess",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MyResponse> call, Throwable t) {
                    Toast.makeText(FinishActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(FinishActivity.this,"No connection",Toast.LENGTH_SHORT).show();

        }
    }
}
