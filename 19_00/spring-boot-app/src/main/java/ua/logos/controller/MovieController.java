package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.entity.MovieEntity;
import ua.logos.service.MovieService;
import ua.logos.service.impl.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("movies") // localhost:8080/movies/***
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> createMovie(
            @RequestBody MovieEntity movieEntity
    ) {
        System.out.println(
                movieEntity.getTitle() + " " +
                movieEntity.getDescription() + " " +
                movieEntity.getCategory() + " " +
                movieEntity.getDuration() + " " +
                movieEntity.getAgeRating()
        );
        movieService.saveMovie(movieEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getMovies() {
        List<MovieEntity> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("{movieId:[0-9]{1,5}}") // \\d
    public ResponseEntity<?> getMovieById(@PathVariable("movieId") Long id) {
        MovieEntity movie = movieService.findMovieById(id);

        if (movie == null) {
            return new ResponseEntity<>("No element found",HttpStatus.NOT_FOUND);//404
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("{movieId:[0-9]{1,5}}")
    public ResponseEntity<?> updateMovie(
            @PathVariable("movieId") Long id,
            @RequestBody MovieEntity movieToUpdate
    ) {
        MovieEntity movie = movieService.updateMovie(id, movieToUpdate);

        if (movie == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
        }

        return new ResponseEntity<>(movie, HttpStatus.OK); // 200
    }
}
