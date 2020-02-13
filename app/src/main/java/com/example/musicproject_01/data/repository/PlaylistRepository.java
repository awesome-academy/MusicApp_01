package com.example.musicproject_01.data.repository;

import com.example.musicproject_01.data.source.PlaylistDataSource;
import com.example.musicproject_01.data.source.remote.playlist.PlaylistRemoteDataSource;

public class PlaylistRepository {

    private static PlaylistRepository sPlaylistRepository;
    private PlaylistRemoteDataSource mPlaylistRemoteDataSource;

    private PlaylistRepository(PlaylistRemoteDataSource playlistRemoteDataSource) {
        mPlaylistRemoteDataSource = playlistRemoteDataSource;
    }

    public static PlaylistRepository getInstance() {
        if (sPlaylistRepository == null) {
            sPlaylistRepository = new PlaylistRepository(PlaylistRemoteDataSource.getInstance());
        }
        return sPlaylistRepository;
    }

    public void getPlaylist(PlaylistDataSource.OnFetchPlaylistDataListener listener) {
        mPlaylistRemoteDataSource.getPlaylist(listener);
    }
}
