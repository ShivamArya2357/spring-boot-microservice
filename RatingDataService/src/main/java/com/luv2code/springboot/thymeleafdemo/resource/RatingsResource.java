package com.luv2code.springboot.thymeleafdemo.resource;

import com.luv2code.springboot.thymeleafdemo.model.Rating;
import com.luv2code.springboot.thymeleafdemo.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, "4");
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("12", "4"),
                new Rating("20", "3")
        );
        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);
        return userRating;
    }
}
