package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.Movie;
import com.springboot.app.moviebooking.repositories.MovieRepository;
import com.springboot.app.moviebooking.services.MovieService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService {

    private final MovieRepository repository;

    private static Logger logger = LoggerFactory.getLogger(MovieServiceImp.class);


    @Override
    public List<Movie> getAllMovies(Integer pageNumber, Integer pageSize) {

        Page<Movie> page = repository.findAll(PageRequest.of(pageNumber, pageSize));

        return page.getContent();
    }

    @Override
    public Movie getMovie(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie movieToUpdate = repository.findById(id).orElse(new Movie());

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDescription(movie.getDescription());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setYearOfProduction(movie.getYearOfProduction());

        return repository.save(movieToUpdate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
