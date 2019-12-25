package com.example.musicproject_01.data.model;

public class Track {
    private String mArtworkUrl;
    private String mTitle;
    private String mGenre;
    private int mDuration;
    private String mUri;
    private int mId;
    private String mDownloadUrl;
    private int mDownloadCount;
    private boolean mIsDownloadable;

    public Track(Builder builder) {

        mArtworkUrl = builder.mArtworkUrl;
        mTitle = builder.mTitle;
        mGenre = builder.mGenre;
        mDuration = builder.mDuration;
        mUri = builder.mUri;
        mId = builder.mId;
        mDownloadUrl = builder.mDownloadUrl;
        mDownloadCount = builder.mDownloadCount;
        mIsDownloadable = builder.mIsDownloadable;

    }

    public static class Builder {
        private String mArtworkUrl;
        private String mTitle;
        private String mGenre;
        private int mDuration;
        private String mUri;
        private int mId;
        private String mDownloadUrl;
        private int mDownloadCount;
        private boolean mIsDownloadable;

        public Builder withArtworkUrl(String artworkUrl) {
            this.mArtworkUrl = artworkUrl;
            return this;
        }

        public Builder withTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder withGenre(String genre) {
            this.mGenre = genre;
            return this;
        }

        public Builder withDuration(int duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder withUri(String uri) {
            this.mUri = uri;
            return this;
        }

        public Builder withId(int id) {
            this.mId = id;
            return this;
        }

        public Builder withDownloadUrl(String downloadUrl) {
            this.mDownloadUrl = downloadUrl;
            return this;
        }

        public Builder withDownloadCount(int downloadCount) {
            this.mDownloadCount = downloadCount;
            return this;
        }

        public Builder withIsDownloadable(boolean isDownloadable) {
            this.mIsDownloadable = isDownloadable;
            return this;
        }

        public Track build() {
            return new Track(this);
        }
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        mDownloadUrl = downloadUrl;
    }

    public int getDownloadCount() {
        return mDownloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        mDownloadCount = downloadCount;
    }

    public boolean isDownloadable() {
        return mIsDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mIsDownloadable = downloadable;
    }
}
