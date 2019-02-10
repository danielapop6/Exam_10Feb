package com.example.danaa.exam_10feb.Remote;

import com.example.danaa.exam_10feb.Model.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataClient {
    @GET("/question")
    Call<List<Question>> getQuestions();

//    @POST("/profiles")
//    Call<Profile> addProfile(@Header("Authorization") String token, @Body Profile profile);
//
//    @PUT("/profiles")
//    Call<Profile> updateProfile(@Header("Authorization") String token, @Body Profile profile);
//
//    @DELETE("/note/{id}")
//    Call<Note> deleteNote(@Path("id") Integer id);

}
