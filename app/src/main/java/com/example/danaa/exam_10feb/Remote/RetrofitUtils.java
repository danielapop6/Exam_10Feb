package com.example.danaa.exam_10feb.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.43.156:3000/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }
}
