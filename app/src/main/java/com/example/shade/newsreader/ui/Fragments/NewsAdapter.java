package com.example.shade.newsreader.ui.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shade.newsreader.R;
import com.example.shade.newsreader.data.network.model.Article;
import com.example.shade.newsreader.ui.NewsDetails.view.NewsDetails;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
{
    List<Article> news;
    Context context;

    public NewsAdapter(Context context,List<Article> news) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_view_holder, parent, false);

        Log.d("resultis","on creatviewholder");


        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position)
    {
        holder.title.setText(news.get(position).getTitle());
        if(news.get(position).getSource().getName().equals(""))
            holder.source.setText("No Source");
        else
            holder.source.setText(news.get(position).getSource().getName());

        if(news.get(position).getUrlToImage()==null)
        {
            holder.imageView.setImageResource(R.drawable.errorimage);
        }
        else
        {
            Glide.with(holder.itemView)
                    .load(news.get(position).getUrlToImage())
                    .into(holder.imageView);

        }

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsDetails.class);
                intent.putExtra("title",news.get(position).getTitle());
                intent.putExtra("source",news.get(position).getSource().getName());
                intent.putExtra("image",news.get(position).getUrlToImage());
                intent.putExtra("link",news.get(position).getUrl());
                intent.putExtra("published",news.get(position).getPublishedAt());
                intent.putExtra("description",news.get(position).getDescription());
                context.startActivity(intent);
            }
        });


        Log.d("resultis","in bind view succ");

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
         TextView title, source;
         ImageView imageView;
         ConstraintLayout constraintLayout;

        public NewsViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.articleTitle);
            source = (TextView) view.findViewById(R.id.articleSource);
            imageView=(ImageView) view.findViewById(R.id.articleImage);
            constraintLayout=(ConstraintLayout) view.findViewById(R.id.viewholderConstraintLayout);
        }
    }
}
