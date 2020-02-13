package com.example.musicproject_01.data.model;

public class Genre {
    private String mTitle;
    private int mImage;

    public Genre() {

    }

    public Genre(String title, int image) {
        mTitle = title;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

}
