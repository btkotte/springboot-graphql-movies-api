package com.bkotte.graphql.movies.repo;

import com.bkotte.graphql.movies.model.Movie;
import com.bkotte.graphql.movies.model.Rating;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    private final DirectorRepository directorRepository;

    public List<Movie> findAll() {
        return movies;
    }

    public Movie findOne(Integer id) {
        return movies.stream().filter(movie -> movie.id() == id).findFirst().orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @PostConstruct
    private void init() {
        movies.add(new Movie(1, "RRR", Rating.FIVE_STARS, directorRepository.findByName("Rajamouli SS")));
        movies.add(new Movie(2, "Pushpa", Rating.FIVE_STARS, directorRepository.findByName("Sukumar B")));
    }
}
