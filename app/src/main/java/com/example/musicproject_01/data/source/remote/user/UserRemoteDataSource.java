package com.example.musicproject_01.data.source.remote.user;

import com.example.musicproject_01.data.source.UserDataSource;
import com.example.musicproject_01.utils.StringUtil;

public class UserRemoteDataSource implements UserDataSource.RemoteDataSource {

    private static UserRemoteDataSource sUserRemoteDataSource;

    private UserRemoteDataSource() {

    }

    public static UserRemoteDataSource getInstance() {
        if (sUserRemoteDataSource == null) {
            sUserRemoteDataSource = new UserRemoteDataSource();
        }
        return sUserRemoteDataSource;
    }

    @Override
    public void getUserList(UserDataSource.OnFetchUserDataListeners listeners) {
        FetchUserFromUrl fetchUserFromUrl = new FetchUserFromUrl(listeners);
        fetchUserFromUrl.execute(StringUtil.formatTrackAPI());
    }
}
