package com.example.musicproject_01.data.model;

public class Playlist {

    private int mDuration;
    private String mPermalinkUrl;
    private String mGenre;
    private String mUri;
    private String mTrackCount;
    private String mTitle;
    private String mArtworkUrl;
    private Track mTrack;
    private User mUser;

    public Playlist(Builder builder) {
        mDuration = builder.mDuration;
        mPermalinkUrl = builder.mPermalinkUrl;
        mGenre = builder.mGenre;
        mUri = builder.mUri;
        mTrackCount = builder.mTrackCount;
        mTitle = builder.mTitle;
        mArtworkUrl = builder.mArtworkUrl;
        mTrack = builder.mTrack;
        mUser = builder.mUser;
    }


    public static class Builder {
        private int mDuration;
        private String mPermalinkUrl;
        private String mGenre;
        private String mUri;
        private String mTrackCount;
        private String mTitle;
        private String mArtworkUrl;
        private Track mTrack;
        private User mUser;

        public Builder withDuration(int duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder withPermalinkUrl(String permalinkUrl) {
            this.mPermalinkUrl = permalinkUrl;
            return this;
        }

        public Builder withGenre(String genre) {
            this.mGenre = genre;
            return this;
        }

        public Builder withUri(String uri) {
            this.mUri = uri;
            return this;
        }

        public Builder withTrackCount(String trackCount) {
            this.mTrackCount = trackCount;
            return this;
        }

        public Builder withTitle(String title) {
            this.mTitle = title;
            return this;
        }

        public Builder withArtworkUrl(String artworkUrl) {
            this.mArtworkUrl = artworkUrl;
            return this;
        }

        public Builder withTrack(Track track) {
            this.mTrack = track;
            return this;
        }

        public Builder withUser(User user) {
            this.mUser = user;
            return this;
        }

        public Playlist build() {
            return new Playlist(this);
        }
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public String getPermalinkUrl() {
        return mPermalinkUrl;
    }

    public void setPermalinkUrl(String permalinkUrl) {
        mPermalinkUrl = permalinkUrl;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getTrackCount() {
        return mTrackCount;
    }

    public void setTrackCount(String trackCount) {
        mTrackCount = trackCount;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public Track getTrack() {
        return mTrack;
    }

    public void setTrack(Track track) {
        mTrack = track;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }
}
