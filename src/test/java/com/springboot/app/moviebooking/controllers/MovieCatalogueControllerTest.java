package com.springboot.app.moviebooking.controllers;

import com.springboot.app.moviebooking.model.Movie;
import com.springboot.app.moviebooking.services.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieCatalogueControllerTest {

    @Autowired
    private MovieController catalogueController;

    @Test
    public void getAllMovies() {

        var provided = catalogueController.getAllMovies(1,10);

        List<Movie> expected = new ArrayList<>();

        assertNotNull(provided);
        assertEquals(expected, provided.getBody());
        assertEquals(HttpStatus.OK, provided.getStatusCode());
    }


    @Test
    public void unitTestController() {
        MovieService service = Mockito.mock(MovieService.class);

        MovieController controller = new MovieController(service);

        List<Movie> expected = new ArrayList<>();

        var provided = controller.getAllMovies(anyInt(), anyInt());

        assertNotNull(controller);
        assertEquals(expected, provided.getBody());
        assertEquals(HttpStatus.OK, provided.getStatusCode());
    }

    @Test
    public void getMovieTest() {
        var provided = catalogueController.getMovie(1L);

        assertNotNull(provided);
        assertEquals(new Movie(), provided.getBody());
    }


    @Test
    public void getMovieTestWithContent() {

        MovieService service = Mockito.mock(MovieService.class);

        when(service.getMovie(anyLong())).thenReturn(Movie.builder()
                .title("The Simpsons")
                .description("is a 2007 American animated comedy film based on the long-running animated sitcom The Simpsons.")
                .id(1L)
                .yearOfProduction(Date.valueOf("2007-01-01"))
                .build());

        MovieController controller = new MovieController(service);

        var provided = controller.getMovie(anyLong());

        assertNotNull(provided);
        assertEquals(HttpStatus.OK, provided.getStatusCode());
        assertEquals("The Simpsons", provided.getBody().getTitle());
    }
}
