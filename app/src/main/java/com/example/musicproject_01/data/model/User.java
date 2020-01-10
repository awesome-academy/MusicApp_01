package com.example.musicproject_01.data.model;

public class User {
    private String mName;
    private String mAvatarUrl;
    private String mId;

    public User() {

    }

    public User(String name, String avatarUrl, String id) {
        mName = name;
        mAvatarUrl = avatarUrl;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}
