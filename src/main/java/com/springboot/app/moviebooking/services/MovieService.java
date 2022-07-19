package com.springboot.app.moviebooking.services;

import com.springboot.app.moviebooking.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies(Integer pageNumber, Integer pageSize);

    Movie getMovie(Long id);

    Movie create(Movie movie);

    Movie update(Long id, Movie movie);

    void delete(Long id);
}
