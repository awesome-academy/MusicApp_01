package com.example.musicproject_01.data.source;

import com.example.musicproject_01.data.model.Track;

import java.util.List;

public interface TrackDataSource {

    interface OnFetchTrackDataListener {
        void onFetchTrackSuccess(List<Track> data);

        void onFetchTrackFailure(Exception e);
    }

    interface RemoteDataSource {
        void getTrackList (OnFetchTrackDataListener listener);
    }

    interface Local {
        List<Track> getAllLocalTrack();
    }
}
