package com.example.musicproject_01.constant;

import androidx.annotation.StringDef;

@StringDef({
        UserEntity.NAME,
        UserEntity.AVATAR_URL,
        UserEntity.ID
})

public @interface UserEntity {
    String NAME = "username";
    String AVATAR_URL = "avatar_url";
    String ID = "id";
}
