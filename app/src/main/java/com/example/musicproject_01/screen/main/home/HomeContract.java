package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.User;

import java.util.List;

public interface HomeContract {

    interface View {

        void onGetTrackSuccess(List<Track> trackList);

        void onGetTrackFailure(String message);

        void onGetPlaylistSuccess(List<Playlist> playlist);

        void onGetPlaylistFailure(String message);

        void showGenres(List<Genre> genres);

        void onGetUserSuccess(List<User> users);

        void onGetUserFail(String message);

    }

    interface Presenter {

        void getTrackList();

        void getPlaylist();

        void loadGenres();

        void getUser();
    }

}
