package com.example.musicproject_01.data.model;

public class Genre {
    private String mTitle;
    private int mImage;
    private String mYear;

    public Genre() {

    }

    public Genre(String title, int image, String year) {
        mTitle = title;
        mImage = image;
        mYear = year;
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

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

}
