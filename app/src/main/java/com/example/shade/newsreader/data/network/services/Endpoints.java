package com.example.shade.newsreader.data.network.services;

import com.example.shade.newsreader.data.network.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Endpoints
{
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("country") String country, @Query("apiKey") String apikey);

    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlinesByCategory(@Query("country") String country,@Query("category") String category, @Query("apiKey") String apikey);

    @GET("everything?sortBy=publishedAt")
    Call<NewsResponse> searchNews(@Query("q") String searchString,@Query("apiKey") String apikey);

    @GET("everything?sortBy=publishedAt")
    Call<NewsResponse> searchNewsByLanguae(@Query("q") String searchString,@Query("language") String language,@Query("apiKey") String apikey);



}
