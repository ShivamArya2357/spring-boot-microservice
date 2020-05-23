package com.luv2code.springboot.thymeleafdemo.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserRating {

    private List<Rating> userRatings;
}
