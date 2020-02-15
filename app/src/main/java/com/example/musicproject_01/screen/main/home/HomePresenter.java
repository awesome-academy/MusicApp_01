package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.model.Playlist;
import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.model.User;
import com.example.musicproject_01.data.repository.GenreRepository;
import com.example.musicproject_01.data.repository.PlaylistRepository;
import com.example.musicproject_01.data.repository.TrackRepository;
import com.example.musicproject_01.data.repository.UserRepository;
import com.example.musicproject_01.data.source.PlaylistDataSource;
import com.example.musicproject_01.data.source.TrackDataSource;
import com.example.musicproject_01.data.source.UserDataSource;
import com.example.musicproject_01.data.source.local.LocalGenreDataSource;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter,
        TrackDataSource.OnFetchTrackDataListener,
        PlaylistDataSource.OnFetchPlaylistDataListener,
        UserDataSource.OnFetchUserDataListeners {

    private HomeContract.View mView;
    private TrackRepository mTrackRepository;
    private PlaylistRepository mPlaylistRepository;
    private GenreRepository mGenreRepository;
    private UserRepository mUserRepository;

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mTrackRepository = TrackRepository.getInstance();
        mPlaylistRepository = PlaylistRepository.getInstance();
        mGenreRepository = GenreRepository.getInstance(new LocalGenreDataSource());
        mUserRepository = UserRepository.getInstance();
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
    public void loadGenres() {
        List<Genre> genres = mGenreRepository.getGenres();
        mView.showGenres(genres);
    }

    @Override
    public void getUser() {
        mUserRepository.getUserList(this);
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

    @Override
    public void onFetchUserSuccess(List<User> dataUser) {
        mView.onGetUserSuccess(dataUser);
    }

    @Override
    public void onFetchUserFail(Exception e) {
        mView.onGetUserFail(e.getMessage());
    }
}
