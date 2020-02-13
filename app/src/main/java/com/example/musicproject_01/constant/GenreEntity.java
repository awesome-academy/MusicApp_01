package com.example.musicproject_01.constant;

import androidx.annotation.StringDef;

@StringDef({
        GenreEntity.ALTERNATIVE,
        GenreEntity.AMBIENT,
        GenreEntity.CLASSICAL,
        GenreEntity.COUNTRY,
        GenreEntity.HIP_HOP,
        GenreEntity.INDIE,
        GenreEntity.POP,
        GenreEntity.ALTERNATIVE_TITLE,
        GenreEntity.AMBIENT_TITLE,
        GenreEntity.CLASSICAL_TITLE,
        GenreEntity.COUNTRY_TITLE,
        GenreEntity.HIP_HOP_TITLE,
        GenreEntity.INDIE_TITLE,
        GenreEntity.POP_TITLE,
        GenreEntity.OTHER_TITLE
})

public @interface GenreEntity {

    String HIP_HOP = "hip_hop";
    String POP = "pop";
    String CLASSICAL = "classical";
    String COUNTRY = "country";
    String ALTERNATIVE = "alternative";
    String AMBIENT = "ambient";
    String INDIE = "indie";

    String HIP_HOP_TITLE = "Hip Hop";
    String POP_TITLE = "Pop";
    String CLASSICAL_TITLE = "Classical";
    String COUNTRY_TITLE = "Country";
    String ALTERNATIVE_TITLE = "Alternative";
    String AMBIENT_TITLE = "Ambient";
    String INDIE_TITLE = "Indie";
    String OTHER_TITLE = "Other";

}
