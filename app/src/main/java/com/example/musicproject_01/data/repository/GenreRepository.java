package com.example.musicproject_01.data.repository;

import com.example.musicproject_01.data.model.Genre;
import com.example.musicproject_01.data.source.GenresDataSource;

import java.util.List;

public class GenreRepository {
    private static GenreRepository sGenreRepository;
    private GenresDataSource mGenresDataSource;

    private GenreRepository(GenresDataSource genresDataSource) {
        mGenresDataSource = genresDataSource;
    }

    public static GenreRepository getInstance(GenresDataSource genresDataSource) {
        if (sGenreRepository == null) {
            sGenreRepository = new GenreRepository(genresDataSource);
        }
        return sGenreRepository;
    }

    public List<Genre> getGenres() {
        return mGenresDataSource.getGenres();
    }
}
