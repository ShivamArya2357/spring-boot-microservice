package com.luv2code.springboot.thymeleafdemo.resource;

import com.luv2code.springboot.thymeleafdemo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getCatalog(@PathVariable("movieId") String movieId) {

        return new Movie(movieId, "Test name");
    }
}
