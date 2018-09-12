package com.example.shade.newsreader.ui.NewsDetails.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shade.newsreader.R;

public class NewsDetails extends AppCompatActivity {

    TextView title;
    TextView description;
    TextView published;
    TextView source;
    Button articleLink;
    ImageView articleImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

         title=(TextView) findViewById(R.id.articleTitleView);
         description=(TextView) findViewById(R.id.articleDescriptionView);
         published=(TextView) findViewById(R.id.articlePublishedView);
         source=(TextView) findViewById(R.id.articleSourceView);
         articleLink=(Button) findViewById(R.id.articleLinkButton);
         articleImage=(ImageView) findViewById(R.id.articleImageView);


        final Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            title.setText(bundle.getString("title"));
            description.setText(bundle.getString("description"));
            published.setText(bundle.getString("published"));

            if(bundle.getString("source")==null)
                source.setText("No Source");
            else
                source.setText(bundle.getString("source"));

            if(bundle.getString("image")==null)
                articleImage.setImageResource(R.drawable.errorimage);
            else
            Glide.with(this)
                    .load(bundle.getString("image"))
                    .into(articleImage);

            articleLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(bundle.getString("link")));
                    startActivity(i);
                }
            });
        }





    }
}
