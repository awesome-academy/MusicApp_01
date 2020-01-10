package com.example.musicproject_01.constant;

import androidx.annotation.StringDef;

@StringDef({
        PlaylistEntity.DURATION,
        PlaylistEntity.PERMALINK_URL,
        PlaylistEntity.GENRE,
        PlaylistEntity.URI,
        PlaylistEntity.TRACK_COUNT,
        PlaylistEntity.TITLE,
        PlaylistEntity.ARTWORK_URL,
        PlaylistEntity.TRACK,
        PlaylistEntity.USER
})

public @interface PlaylistEntity {
    String DURATION = "duration";
    String PERMALINK_URL = "permalink_url";
    String GENRE = "genre";
    String URI = "uri";
    String TRACK_COUNT = "track_count";
    String TITLE = "title";
    String ARTWORK_URL = "artwork_url";
    String TRACK = "tracks";
    String USER = "user";

}
