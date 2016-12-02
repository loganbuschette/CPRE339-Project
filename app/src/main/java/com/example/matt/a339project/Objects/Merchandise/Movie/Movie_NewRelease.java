package com.example.matt.a339project.Objects.Merchandise.Movie;

import com.example.matt.a339project.Objects.Merchandise.Movie.Movie;

/**
 * Created by Matt on 11/16/2016.
 */

public class Movie_NewRelease extends Movie {

    public Movie_NewRelease(String title) {
        super(title);
    }

    public Movie_NewRelease(String title, int daysRented){ super(title, daysRented);}

    @Override
    public double getRentalCost() {
        frequentCustomerPoints = 1;
        return (double) 3 * daysRented;
    }

    @Override
    public double getSaleCost(){
        frequentCustomerPoints = 2;
        return 15;
    }

    @Override
    public int getFrequentCustomerPointCost(){
        return 50;
    }
}
