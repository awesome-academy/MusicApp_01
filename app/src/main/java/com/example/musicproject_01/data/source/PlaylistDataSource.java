package com.example.musicproject_01.data.source;

import com.example.musicproject_01.data.model.Playlist;

import java.util.List;

public interface PlaylistDataSource {
    interface OnFetchPlaylistDataListener {
        void onFetchPlaylistSuccess(List<Playlist> data);

        void onFetchDataPlaylistFailure(Exception e);
    }

    interface RemoteDataSource {
        void getPlaylist(OnFetchPlaylistDataListener listener);
    }

    interface Local {
        List<Playlist> getAllLocalPlaylist();
    }
}
