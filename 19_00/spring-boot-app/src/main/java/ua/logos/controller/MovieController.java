package ua.logos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.entity.MovieEntity;
import ua.logos.service.MovieService;

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

}
