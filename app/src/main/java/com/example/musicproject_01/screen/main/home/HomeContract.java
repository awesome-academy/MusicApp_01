package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Track;

import java.util.List;

public interface HomeContract {
    interface Presenter {

        void loadRecentSongs();

        void loadPlaylist();

        void loadGenres();

    }

    interface View {

        void showRecentSong(List<Track> tracks);

    }
}
