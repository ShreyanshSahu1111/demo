package com.movie.demo.controllers;

import java.util.List;

import com.movie.demo.entity.Movie;
import com.movie.demo.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/searchMovie")
    public Movie searchMovie(@RequestParam String targetMovie){
        return movieRepository.findByName(targetMovie);
    }

    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping(value="/addMovie")
    public String addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return "Following movie has been saved \n" + movie.toString();
    }
    
}
