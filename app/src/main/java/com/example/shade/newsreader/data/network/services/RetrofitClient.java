package com.example.shade.newsreader.data.network.services;

import android.graphics.Movie;

import com.example.shade.newsreader.data.network.model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitClient {
    public static final String apiUrl = "https://newsapi.org/v2/";
    public static Retrofit retrofitInstance=null;

    private RetrofitClient()
    {
    }

    public static Retrofit getInstance()
    {
        if(retrofitInstance==null)
        {
            retrofitInstance=new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofitInstance;

    }

}
