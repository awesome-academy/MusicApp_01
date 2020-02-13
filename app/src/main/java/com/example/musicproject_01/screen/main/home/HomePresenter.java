package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.repository.PlaylistRepository;
import com.example.musicproject_01.data.repository.TrackRepository;
import com.example.musicproject_01.data.source.PlaylistDataSource;
import com.example.musicproject_01.data.source.TrackDataSource;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter,
        TrackDataSource.OnFetchTrackDataListener,
        PlaylistDataSource.OnFetchPlaylistDataListener {

    private HomeContract.View mView;
    private TrackRepository mTrackRepository;
    private PlaylistRepository mPlaylistRepository;

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mTrackRepository = TrackRepository.getInstance();
        mPlaylistRepository = PlaylistRepository.getInstance();
    }

    @Override
    public void getTrackList() {
        mTrackRepository.getTrackList(this);
    }

    @Override
    public void getPlaylist() {
        mPlaylistRepository.getPlaylist(this);
    }

    @Override
    public void onFetchTrackSuccess(List<Track> dataTrack) {
        mView.onGetTrackSuccess(dataTrack);
    }

    @Override
    public void onFetchTrackFailure(Exception e) {
        mView.onGetTrackFailure(e.getMessage());
    }

    @Override
    public void onFetchPlaylistSuccess(List<Playlist> dataPlaylist) {
        mView.onGetPlaylistSuccess(dataPlaylist);
    }

    @Override
    public void onFetchDataPlaylistFailure(Exception e) {
        mView.onGetPlaylistFailure(e.getMessage());
    }
}
