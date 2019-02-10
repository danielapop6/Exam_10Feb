package com.example.danaa.exam_10feb.Remote;

import com.example.danaa.exam_10feb.Model.Answer;
import com.example.danaa.exam_10feb.Model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataClient {
    @GET("/question")
    Call<List<Question>> getQuestions();

    @POST("/quiz")
    Call<MyResponse> sendQuiz(@Body List<Answer> answers);

//    @PUT("/profiles")
//    Call<Profile> updateProfile(@Header("Authorization") String token, @Body Profile profile);
//
//    @DELETE("/note/{id}")
//    Call<Note> deleteNote(@Path("id") Integer id);

}
