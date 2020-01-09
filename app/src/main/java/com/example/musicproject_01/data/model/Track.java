package com.example.musicproject_01.data.model;

public class Track {
    private String mArtworkUrl;
    private String mTitle;
    private String mGenre;
    private String mPermalinkUrl;
    private String mUri;
    private String mStreamUrl;
    private int mId;
    private int mDuration;
    private int mDownloadCount;
    private boolean mIsDownloadable;
    private User mUser;

    public Track(Builder builder) {

        mArtworkUrl = builder.mArtworkUrl;
        mTitle = builder.mTitle;
        mGenre = builder.mGenre;
        mPermalinkUrl = builder.mPermalinkUrl;
        mUri = builder.mUri;
        mStreamUrl = builder.mStreamUrl;
        mId = builder.mId;
        mDuration = builder.mDuration;
        mDownloadCount = builder.mDownloadCount;
        mIsDownloadable = builder.mIsDownloadable;
        mUser = builder.mUser;

    }

    public static class Builder {
        private String mArtworkUrl;
        private String mTitle;
        private String mGenre;
        private String mPermalinkUrl;
        private String mUri;
        private String mStreamUrl;
        private int mId;
        private int mDuration;
        private int mDownloadCount;
        private boolean mIsDownloadable;
        private User mUser;

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

        public Builder withPermalinkUrl(String permalinkUrl) {
            this.mPermalinkUrl = permalinkUrl;
            return this;
        }


        public Builder withUri(String uri) {
            this.mUri = uri;
            return this;
        }

        public Builder withStreamUrl(String streamUrl) {
            this.mStreamUrl = streamUrl;
            return this;
        }

        public Builder withId(int id) {
            this.mId = id;
            return this;
        }

        public Builder withDuration(int duration) {
            this.mDuration = duration;
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

        public Builder withUser(User user) {
            this.mUser = user;
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

    public String getPermalinkUrl() {
        return mPermalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        mPermalinkUrl = permalinkUrl;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        mStreamUrl = streamUrl;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
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

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
