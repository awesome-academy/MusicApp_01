package com.example.musicproject_01.data.model;

public class Track {
    private String mArtworkUrl;
    private String mDescription;
    private String mTitle;
    private String mGenre;
    private int mDuration;
    private String mUri;
    private int mId;
    private String mDownloadUrl;
    private int mDownloadCount;
    private boolean mIsDownloadable;

    public Track() {

    }

    public Track(String mArtworkUrl, String mDescription, String mTitle, String mGenre, int mDuration, String mUri, int mId, String mDownloadUrl, int mDownloadCount, boolean mIsDownloadable) {
        this.mArtworkUrl = mArtworkUrl;
        this.mDescription = mDescription;
        this.mTitle = mTitle;
        this.mGenre = mGenre;
        this.mDuration = mDuration;
        this.mUri = mUri;
        this.mId = mId;
        this.mDownloadUrl = mDownloadUrl;
        this.mDownloadCount = mDownloadCount;
        this.mIsDownloadable = mIsDownloadable;
    }

    public String getmArtworkUrl() {
        return mArtworkUrl;
    }

    public void setmArtworkUrl(String mArtworkUrl) {
        this.mArtworkUrl = mArtworkUrl;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public int getmDuration() {
        return mDuration;
    }

    public void setmDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmDownloadUrl() {
        return mDownloadUrl;
    }

    public void setmDownloadUrl(String mDownloadUrl) {
        this.mDownloadUrl = mDownloadUrl;
    }

    public int getmDownloadCount() {
        return mDownloadCount;
    }

    public void setmDownloadCount(int mDownloadCount) {
        this.mDownloadCount = mDownloadCount;
    }

    public boolean ismIsDownloadable() {
        return mIsDownloadable;
    }

    public void setmIsDownloadable(boolean mIsDownloadable) {
        this.mIsDownloadable = mIsDownloadable;
    }
}
