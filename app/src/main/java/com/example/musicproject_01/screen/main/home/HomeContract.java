package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.Track;

import java.util.List;

public interface HomeContract {

    interface View {

        void onGetTrackSuccess(List<Track> trackList);

        void onGetTrackFailure(String message);

        void onGetPlaylistSuccess(List<Playlist> playlist);

        void onGetPlaylistFailure(String message);

    }

    interface Presenter {

        void getTrackList();

        void getPlaylist();

    }

}
