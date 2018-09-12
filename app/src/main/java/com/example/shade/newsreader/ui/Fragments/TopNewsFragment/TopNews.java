package com.example.shade.newsreader.ui.Fragments.TopNewsFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.example.shade.newsreader.R;
import com.example.shade.newsreader.data.network.model.Article;
import com.example.shade.newsreader.ui.Fragments.NewsAdapter;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class TopNews extends Fragment implements TopNewsView
{
    RecyclerView recyclerView;
    TopNewsPresenter topNewsPresenter;
    NewsAdapter newsAdapter;


    public TopNews() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.top_news_fragment_layout,container,false);

        topNewsPresenter=new TopNewsPresenter(this);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerviewTopNews);

        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", 0);
        String country = pref.getString("country", null);

        if(country==null)
          topNewsPresenter.makeRequest("eg");
        else
            topNewsPresenter.makeRequest(country);


        return  view;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences pref = this.getActivity().getSharedPreferences("MyPref", 0);
        String country = pref.getString("country", null);

        if(country==null)
            topNewsPresenter.makeRequest("eg");
        else
            topNewsPresenter.makeRequest(country);
    }

    @Nullable
    @Override
    public Context getContext() {
        return this.getActivity();
    }

    @Override
    public void populateUi(List<Article> news)
    {
       setRecyclerView(news);
    }

    public void setRecyclerView(List<Article> news)
    {
        newsAdapter=new NewsAdapter(this.getActivity(),news);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(newsAdapter);

    }
}
