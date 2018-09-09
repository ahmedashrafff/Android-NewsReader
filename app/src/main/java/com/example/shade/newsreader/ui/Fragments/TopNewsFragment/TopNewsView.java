package com.example.shade.newsreader.ui.Fragments.TopNewsFragment;

import android.content.Context;

import com.example.shade.newsreader.data.network.model.Article;

import java.util.List;

public interface TopNewsView {

    public Context getContext();
    public void populateUi(List<Article> news);
}
