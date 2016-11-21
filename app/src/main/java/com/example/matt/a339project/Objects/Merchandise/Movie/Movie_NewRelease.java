package com.example.matt.a339project.Objects.Merchandise.Movie;

import com.example.matt.a339project.Objects.Merchandise.Movie.Movie;

/**
 * Created by Matt on 11/16/2016.
 */

public class Movie_NewRelease extends Movie {

    public Movie_NewRelease(String title) {
        super(title);
    }

    @Override
    public double getRentalCost(int daysRented) {
        frequentCustomerPoints = 1;
        return (double) 3 * daysRented;
    }

    @Override
    public double getSaleCost(){
        frequentCustomerPoints = 2;
        return 15;
    }
}
