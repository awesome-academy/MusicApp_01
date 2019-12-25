package com.example.musicproject_01.constant;

import androidx.annotation.StringDef;

@StringDef({
        TrackEntity.COLLECTION,
        TrackEntity.TRACK,
        TrackEntity.ARTWORK_URL,
        TrackEntity.LARGE_IMAGE_SIZE,
        TrackEntity.BETTER_IMAGE_SIZE,
        TrackEntity.USER,
        TrackEntity.ARTWORK_URL,
        TrackEntity.DESCRIPTION,
        TrackEntity.DOWNLOADABLE,
        TrackEntity.DOWNLOAD_URL,
        TrackEntity.DOWNLOAD_COUNT,
        TrackEntity.DURATION,
        TrackEntity.ID,
        TrackEntity.TITLE,
        TrackEntity.URI
})

public @interface TrackEntity {
    String COLLECTION = "collection";
    String TRACK = "track";
    String ARTWORK_URL = "artwork_url";
    String LARGE_IMAGE_SIZE = "large";
    String BETTER_IMAGE_SIZE = "original";
    String USER = "user";

    String AVATAR_URL = "avatar_url";
    String DESCRIPTION = "description";

    String DOWNLOADABLE = "downloadable";
    String DOWNLOAD_URL = "download_url";
    String DOWNLOAD_COUNT = "download_count";
    String DURATION = "duration";
    String GENRE = "genre";
    String ID = "id";
    String TITLE = "title";
    String URI = "uri";
}
