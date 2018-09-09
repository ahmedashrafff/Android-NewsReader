package com.example.shade.newsreader.ui.Fragments.TopicsFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shade.newsreader.R;

public class Topics extends Fragment implements TopicsView
{


    public Topics() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.tags_fragment_layout,container,false);


        return  view;
    }
}
