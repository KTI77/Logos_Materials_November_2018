package ua.logos.service;

import ua.logos.entity.MovieEntity;

import java.util.List;

public interface MovieService {

    void saveMovie(MovieEntity movie);

    List<MovieEntity> findAllMovies();

    MovieEntity findMovieById(Long id);
}
