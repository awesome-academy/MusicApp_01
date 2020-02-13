package com.example.musicproject_01.data.source.remote.track;

import com.example.musicproject_01.data.source.TrackDataSource;
import com.example.musicproject_01.utils.StringUtil;

public class TrackRemoteDataSource implements TrackDataSource.RemoteDataSource {

    private static TrackRemoteDataSource sTrackRemoteDataSource;

    private TrackRemoteDataSource() {

    }

    public static TrackRemoteDataSource getInstance() {
        if (sTrackRemoteDataSource == null) {
            sTrackRemoteDataSource = new TrackRemoteDataSource();
        }
        return sTrackRemoteDataSource;
    }

    @Override
    public void getTrackList(TrackDataSource.OnFetchTrackDataListener listener) {
        FetchTrackFromUrl fetchTrackFromUrl = new FetchTrackFromUrl(listener);
        fetchTrackFromUrl.execute(StringUtil.formatTrackAPI());
    }
}
