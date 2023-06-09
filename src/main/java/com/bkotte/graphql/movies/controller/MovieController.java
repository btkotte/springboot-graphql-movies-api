package com.bkotte.graphql.movies.controller;

import com.bkotte.graphql.movies.model.Movie;
import com.bkotte.graphql.movies.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    //@SchemaMapping(typeName = "Query", value = "allMovies")
    // Below annotation will do the same. But the method name should be same as the type definition in the schema file
    @QueryMapping
    public Flux<Movie> allMovies() {
        return Flux.fromIterable(() -> movieRepository.findAll().iterator());
    }

    @QueryMapping
    public Movie findOne(@Argument Integer id) {
        return movieRepository.findOne(id);
    }

}
