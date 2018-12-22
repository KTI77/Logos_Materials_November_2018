package ua.logos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.logos.entity.MovieEntity;
import ua.logos.repository.MovieRepository;
import ua.logos.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void saveMovie(MovieEntity movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<MovieEntity> findAllMovies() {
        List<MovieEntity> movies =
                movieRepository.findAll();
        return movies;
    }

    @Override
    public MovieEntity findMovieById(Long id) {
        MovieEntity movie = movieRepository.findById(id).get();
        return movie;
    }
}
