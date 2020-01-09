package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Track;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        mView = view;
           }

    @Override
    public void loadRecentSongs() {

    }

    @Override
    public void loadPlaylist() {

    }

    @Override
    public void loadGenres() {

    }
}
