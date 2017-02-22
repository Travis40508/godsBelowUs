package com.example.travis.godsbelowus.Presentation.Presenters;

import android.view.View;

import com.example.travis.godsbelowus.Presentation.Views.MainActivityView;

/**
 * Created by travis on 2/19/17.
 */

public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }


    public void activityCreated() {
        view.buildFragment();
    }
}
