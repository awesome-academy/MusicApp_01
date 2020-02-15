package com.example.musicproject_01.data.repository;

import com.example.musicproject_01.data.source.UserDataSource;
import com.example.musicproject_01.data.source.remote.user.UserRemoteDataSource;

public class UserRepository {

    private static UserRepository sUserRepository;
    private UserRemoteDataSource mUserRemoteDataSource;

    private UserRepository(UserRemoteDataSource userRemoteDataSource) {
        mUserRemoteDataSource = userRemoteDataSource;
    }

    public static UserRepository getInstance() {
        if (sUserRepository == null) {
            sUserRepository = new UserRepository(UserRemoteDataSource.getInstance());
        }
        return sUserRepository;
    }

    public void getUserList(UserDataSource.OnFetchUserDataListeners listeners) {
        mUserRemoteDataSource.getUserList(listeners);
    }
}
