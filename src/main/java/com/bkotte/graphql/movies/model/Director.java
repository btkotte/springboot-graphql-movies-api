package com.bkotte.graphql.movies.model;

public record Director(Integer id, String firstName, String lastName) {
    public String fullName() {
        return firstName + " " + lastName;
    }
}
