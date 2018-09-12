package com.example.shade.newsreader.ui.Home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import com.example.shade.newsreader.R;
import com.example.shade.newsreader.ui.Settings.view.Settings;
import com.example.shade.newsreader.ui.Fragments.TopicsFragment.Topics;
import com.example.shade.newsreader.ui.Fragments.TopNewsFragment.TopNews;
import com.example.shade.newsreader.ui.Home.presenter.TabsPagerAdapter;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

public class Home extends AppCompatActivity implements HomeView
{
    ViewPager viewPager;
    NavigationTabStrip navigationTabStrip;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    ImageButton bookmarks ,settings;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bookmarks=(ImageButton) findViewById(R.id.bookmarks);
        settings=(ImageButton) findViewById(R.id.settings);

        bookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookmarks.startAnimation(buttonClick);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.startAnimation(buttonClick);
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });
        setupViewPager();

    }

    public void setupViewPager()
    {

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        navigationTabStrip = (NavigationTabStrip) findViewById(R.id.tablayout);
        final TabsPagerAdapter pagerAdapter=new TabsPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new TopNews(),"Top News");
        pagerAdapter.addFragment(new Topics(),"Topics");
        viewPager.setAdapter(pagerAdapter);

        navigationTabStrip.setTitles("Top News","Topics");
        navigationTabStrip.setStripWeight(7);
        navigationTabStrip.setStripFactor(2);
        navigationTabStrip.setStripType(NavigationTabStrip.StripType.POINT);
        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
        navigationTabStrip.setCornersRadius(3);
        navigationTabStrip.setAnimationDuration(300);
        navigationTabStrip.setViewPager(viewPager);
    }


}
