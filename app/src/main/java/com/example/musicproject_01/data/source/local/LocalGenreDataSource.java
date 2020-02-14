package com.example.musicproject_01.data.source.local;

import com.example.musicproject_01.R;
import com.example.musicproject_01.constant.GenreEntity;
import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.source.GenresDataSource;

import java.util.ArrayList;
import java.util.List;

public class LocalGenreDataSource implements GenresDataSource {

    @Override
    public List<Genre> getGenres() {

        List<Genre> genres = new ArrayList<>();

        Genre ambient = new Genre(GenreEntity.AMBIENT_TITLE, R.raw.ambient_genre);
        Genre alternative = new Genre(GenreEntity.ALTERNATIVE_TITLE, R.raw.alternative_genre);
        Genre classical = new Genre(GenreEntity.CLASSICAL_TITLE, R.raw.classical_genre);
        Genre country = new Genre(GenreEntity.COUNTRY_TITLE, R.raw.country_genre);
        Genre hip_hop = new Genre(GenreEntity.HIP_HOP_TITLE, R.raw.hip_hop);
        Genre indie = new Genre(GenreEntity.INDIE_TITLE, R.raw.indie_genre);
        Genre pop = new Genre(GenreEntity.POP_TITLE, R.raw.pop_music);
        Genre other = new Genre(GenreEntity.OTHER_TITLE, R.raw.other_genre);

        genres.add(ambient);
        genres.add(alternative);
        genres.add(classical);
        genres.add(country);
        genres.add(hip_hop);
        genres.add(indie);
        genres.add(pop);
        genres.add(other);

        return genres;
    }
}
