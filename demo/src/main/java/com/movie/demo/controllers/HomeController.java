package com.movie.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.movie.demo.entity.Movie;
import com.movie.demo.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("search")
    public Movie search(@RequestParam String movieName){
        return movieRepository.findByName(movieName);
    }
}
