package com.example.musicproject_01.data.repository;

import com.example.musicproject_01.data.source.TrackDataSource;
import com.example.musicproject_01.data.source.remote.track.TrackRemoteDataSource;

public class TrackRepository {

    private static TrackRepository sTrackRepository;
    private TrackRemoteDataSource mTrackRemoteDataSource;

    private TrackRepository(TrackRemoteDataSource trackRemoteDataSource) {
        mTrackRemoteDataSource = trackRemoteDataSource;
    }

    public static TrackRepository getInstance() {
        if (sTrackRepository == null) {
            sTrackRepository = new TrackRepository(TrackRemoteDataSource.getInstance());
        }
        return sTrackRepository;
    }

    public void getTrackList(TrackDataSource.OnFetchTrackDataListener listener) {
        mTrackRemoteDataSource.getTrackList(listener);
    }
}
