package com.example.musicproject_01.data.source;

import com.example.musicproject_01.data.model.User;

import java.util.List;

public interface UserDataSource {

    interface OnFetchUserDataListeners {
        void onFetchUserSuccess(List<User> data);

        void onFetchUserFail(Exception e);
    }

    interface RemoteDataSource {
        void getUserList(OnFetchUserDataListeners listeners);
    }
}
