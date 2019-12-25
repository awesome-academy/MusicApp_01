package com.example.musicproject_01.data.model;

public class Genre {
    private String mName;
    private int mGenreString;
    private int mGenreImage;

    public Genre() {

    }

    public Genre(String mName, int mGenreString, int mGenreImage) {
        this.mName = mName;
        this.mGenreString = mGenreString;
        this.mGenreImage = mGenreImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmGenreString() {
        return mGenreString;
    }

    public void setmGenreString(int mGenreString) {
        this.mGenreString = mGenreString;
    }

    public int getmGenreImage() {
        return mGenreImage;
    }

    public void setmGenreImage(int mGenreImage) {
        this.mGenreImage = mGenreImage;
    }
}
