package com.bkotte.graphql.movies.repo;


import com.bkotte.graphql.movies.model.Director;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DirectorRepository {

    private Map<Integer, Director> directors = new ConcurrentHashMap<>();

    public Collection<Director> findAll() {
        return directors.values();
    }

    public Director findById(int id) {
        return Optional.ofNullable(directors.get(id))
                .orElseThrow(() -> new RuntimeException("Director not found"));
    }

    public Director findByName(String name) {
        return directors.values().stream()
                .filter(director -> director.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Director not found"));
    }

    @PostConstruct
    private void init() {
        directors.put(1, new Director(1, "Rajamouli", "SS"));
        directors.put(2, new Director(2, "Sukumar", "B"));
    }
}

