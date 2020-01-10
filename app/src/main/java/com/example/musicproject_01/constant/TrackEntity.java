package com.example.musicproject_01.constant;

import androidx.annotation.StringDef;

@StringDef({
        TrackEntity.TRACK,
        TrackEntity.ARTWORK_URL,
        TrackEntity.ARTWORK_URL,
        TrackEntity.DOWNLOADABLE,
        TrackEntity.STREAM_URL,
        TrackEntity.DOWNLOAD_COUNT,
        TrackEntity.DURATION,
        TrackEntity.ID,
        TrackEntity.TITLE,
        TrackEntity.URI,
        TrackEntity.USER,
        TrackEntity.PERMALINK_URL
})

public @interface TrackEntity {
    String TRACK = "track";
    String ARTWORK_URL = "artwork_url";
    String DOWNLOADABLE = "downloadable";
    String PERMALINK_URL = "permalink_url";
    String STREAM_URL = "stream_url";
    String DOWNLOAD_COUNT = "download_count";
    String DURATION = "duration";
    String GENRE = "genre";
    String ID = "id";
    String TITLE = "title";
    String URI = "uri";
    String USER = "user";
}
