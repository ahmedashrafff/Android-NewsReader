package com.example.shade.newsreader.ui.Fragments.TopNewsFragment;

import android.util.Log;
import android.widget.Toast;

import com.example.shade.newsreader.R;
import com.example.shade.newsreader.data.network.model.Article;
import com.example.shade.newsreader.data.network.model.NewsResponse;
import com.example.shade.newsreader.data.network.services.Endpoints;
import com.example.shade.newsreader.data.network.services.RetrofitClient;
import com.example.shade.newsreader.ui.Fragments.NewsAdapter;
import com.example.shade.newsreader.ui.Home.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TopNewsPresenter implements TopNewsPresenterInterface
{
    Retrofit retrofit;
    TopNewsView topNewsView;
    String API_Key;

    public TopNewsPresenter(TopNewsView topNewsView)
    {
        this.topNewsView=topNewsView;
        retrofit=RetrofitClient.getInstance();
        API_Key=topNewsView.getContext().getString(R.string.app_name);

    }


    @Override
    public void makeRequest(String country)
    {
        Endpoints endpoints=retrofit.create(Endpoints.class);
        Call<NewsResponse> call = endpoints.getTopHeadlines(country,"0fe8e34f6d844c85b688d9387028d9b6");
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response)
            {
                if(response.isSuccessful())
                {
                    NewsResponse newsResponse=response.body();
                    List<Article> news=newsResponse.getArticles();
                    Log.d("resultis","response succ"+news.get(0).getTitle());
                    topNewsView.populateUi(news);
                    Log.d("resultis","response succ");

                }
                else
                    Log.d("resultis","response failed");

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

                Toast.makeText(topNewsView.getContext(),"Please Try Again",Toast.LENGTH_SHORT);
                Log.d("resultis","response failed on failure");
                Log.d("resultis",t.getMessage());

            }
        });
    }





}
