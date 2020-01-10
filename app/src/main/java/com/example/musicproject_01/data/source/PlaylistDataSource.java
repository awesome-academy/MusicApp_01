package com.example.musicproject_01.data.source;

import com.example.musicproject_01.data.model.Playlist;

import java.util.List;

public interface PlaylistDataSource {
    interface OnFetchDataListener<T> {
        void onFetchDataPlaylistSuccess(List<T> data);

        void onFetchDataPlaylistFailure(Exception e);
    }

    interface Local {
        List<Playlist> getAllLocalPlaylist();
    }
}
