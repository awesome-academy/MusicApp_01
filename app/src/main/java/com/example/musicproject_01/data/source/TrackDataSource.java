package com.example.musicproject_01.data.source;

import java.util.List;

public interface TrackDataSource {

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }

}
