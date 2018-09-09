package com.example.shade.newsreader.ui.Fragments.TopNewsFragment;

import com.example.shade.newsreader.data.network.model.Article;
import com.example.shade.newsreader.ui.Fragments.NewsAdapter;

import java.util.List;

public interface TopNewsPresenterInterface
{
    public void makeRequest(String country);
}
