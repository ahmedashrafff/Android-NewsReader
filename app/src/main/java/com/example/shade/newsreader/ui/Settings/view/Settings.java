package com.example.shade.newsreader.ui.Settings.view;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Toast;

import com.example.shade.newsreader.R;
import com.example.shade.newsreader.ui.Settings.presenter.SettingsPresenter;

public class Settings extends AppCompatActivity implements SettingsView {

    ConstraintLayout egypt;
    ConstraintLayout japan;
    ConstraintLayout usa;
    ConstraintLayout portugal;
    ConstraintLayout germany;
    ConstraintLayout italy;
    ConstraintLayout greece;
    ConstraintLayout france;
    SettingsPresenter settingsPresenter;
    private AlphaAnimation itemClick = new AlphaAnimation(1F, 0.8F);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settingsPresenter=new SettingsPresenter(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        egypt = (ConstraintLayout)findViewById(R.id.egypt);
        france = (ConstraintLayout)findViewById(R.id.france);
        japan = (ConstraintLayout)findViewById(R.id.japan);
        portugal = (ConstraintLayout)findViewById(R.id.portugal);
        germany = (ConstraintLayout)findViewById(R.id.germany);
        italy = (ConstraintLayout)findViewById(R.id.italy);
        usa = (ConstraintLayout)findViewById(R.id.usa);
        greece = (ConstraintLayout)findViewById(R.id.greece);




    }

    public void countryOnClick(View view)
    {
        view.startAnimation(itemClick);

        if (view.getId()==R.id.egypt)
        {
            settingsPresenter.setCountry("eg");
            Toast.makeText(this,"Changed to Egypt",Toast.LENGTH_SHORT).show();

        }

        else if (view.getId()==R.id.france)
        {
            settingsPresenter.setCountry("fr");
            Toast.makeText(this,"Changed to France",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.portugal)
        {
            settingsPresenter.setCountry("pt");
            Toast.makeText(this,"Changed to Portugal",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.japan)
        {
            settingsPresenter.setCountry("jp");
            Toast.makeText(this,"Changed to Japan",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.italy)
        {
            settingsPresenter.setCountry("it");
            Toast.makeText(this,"Changed to Italy",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.germany)
        {
            settingsPresenter.setCountry("de");
            Toast.makeText(this,"Changed to Germany",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.usa)
        {
            settingsPresenter.setCountry("us");
            Toast.makeText(this,"Changed to U.S.A",Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()==R.id.greece)
        {
            settingsPresenter.setCountry("gr");
            Toast.makeText(this,"Changed to Greece",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
