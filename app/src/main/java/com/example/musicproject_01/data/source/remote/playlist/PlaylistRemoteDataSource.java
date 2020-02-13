package com.example.musicproject_01.data.source.remote.playlist;

import com.example.musicproject_01.data.source.PlaylistDataSource;
import com.example.musicproject_01.utils.StringUtil;

public class PlaylistRemoteDataSource implements PlaylistDataSource.RemoteDataSource {

    private static PlaylistRemoteDataSource sPlaylistRemoteDataSource;

    private PlaylistRemoteDataSource() {

    }

    public static PlaylistRemoteDataSource getInstance() {
        if (sPlaylistRemoteDataSource == null) {
            sPlaylistRemoteDataSource = new PlaylistRemoteDataSource();
        }
        return sPlaylistRemoteDataSource;
    }

    @Override
    public void getPlaylist(PlaylistDataSource.OnFetchPlaylistDataListener listener) {
        FetchPlaylistFromUrl fetchPlaylistFromUrl = new FetchPlaylistFromUrl(listener);
        fetchPlaylistFromUrl.execute(StringUtil.formatPlaylistAPI());
    }
}
