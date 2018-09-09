package com.example.shade.newsreader.ui.Settings.presenter;

import android.content.SharedPreferences;

import com.example.shade.newsreader.ui.Settings.view.SettingsView;

public class SettingsPresenter implements SettingsPresenterInterface
{
    SettingsView settingsView;

    public SettingsPresenter(SettingsView settingsView) {
        this.settingsView = settingsView;
    }

    @Override
    public void setCountry(String country) {
        SharedPreferences pref = settingsView.getContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("country", country);
        editor.apply();
    }
}
