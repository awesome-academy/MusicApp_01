package com.example.musicproject_01.screen.main.home;

import com.example.musicproject_01.data.model.Track;
import com.example.musicproject_01.data.repository.TrackRepository;
import com.example.musicproject_01.data.source.TrackDataSource;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter,
        TrackDataSource.OnFetchTrackDataListener {

    private HomeContract.View mView;
    private TrackRepository mTrackRepository;

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mTrackRepository = TrackRepository.getInstance();
    }

    @Override
    public void getTrackList() {
        mTrackRepository.getTrackList(this);
    }

    @Override
    public void onFetchTrackSuccess(List<Track> dataTrack) {
        mView.onGetTrackSuccess(dataTrack);
    }

    @Override
    public void onFetchTrackFailure(Exception e) {
        mView.onGetTrackFailure(e.getMessage());
    }
}
