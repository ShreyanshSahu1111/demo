package com.movie.demo.repositories;

import com.movie.demo.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    Movie findByName(String name);
}
