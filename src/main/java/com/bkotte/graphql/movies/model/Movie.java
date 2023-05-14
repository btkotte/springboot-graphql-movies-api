package com.bkotte.graphql.movies.model;

public record Movie(Integer id, String title, Rating rating, Director director) {
}
