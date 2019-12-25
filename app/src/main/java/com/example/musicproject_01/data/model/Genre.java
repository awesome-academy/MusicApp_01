package com.example.musicproject_01.data.model;

public class Genre {
    private String mTitle;
    private int mImage;
    private String mYear;

    public Genre() {

    }

    public Genre(String Title, int Image, String Year) {
        this.mTitle = Title;
        this.mImage = Image;
        this.mYear = Year;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String Title) {
        this.mTitle = Title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int Image) {
        this.mImage = Image;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String Year) {
        this.mYear = Year;
    }
}
