package com.example.musicproject_01.data.source;

import com.example.musicproject_01.data.model.Track;

import java.util.List;

public interface TrackDataSource {

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }

    interface Local {
        List<Track> getAllLocalTrack();
    }
}
