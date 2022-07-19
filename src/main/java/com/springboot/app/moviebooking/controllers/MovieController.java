package com.springboot.app.moviebooking.controllers;

import com.springboot.app.moviebooking.model.Movie;
import com.springboot.app.moviebooking.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService catalogueService;

    public MovieController(MovieService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(catalogueService.getAllMovies(page, size));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(catalogueService.getMovie(id));
    }

    @PostMapping(value = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(catalogueService.create(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.ok(catalogueService.update(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        catalogueService.delete(id);

        return ResponseEntity.ok("Successfuly deleted");
    }

}
