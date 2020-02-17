package com.example.musicproject_01.data.model;

public class User {
    private String mName;
    private String mAvatarUrl;
    private String mId;
    private String mUserLink;

    public User() {

    }

    public User(String name, String avatarUrl, String userLink) {
        mName = name;
        mAvatarUrl = avatarUrl;
        mUserLink = userLink;
    }

    public User(String name, String avatarUrl, String id, String userLink) {
        mName = name;
        mAvatarUrl = avatarUrl;
        mId = id;
        mUserLink = userLink;
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

    public String getUserLink() {
        return mUserLink;
    }

    public void setUserLink(String userLink) {
        mUserLink = userLink;
    }
}
