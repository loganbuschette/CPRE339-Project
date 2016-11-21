package com.example.matt.a339project.Objects.Merchandise.Movie;

import com.example.matt.a339project.Objects.Merchandise.Movie.Movie;

/**
 * Created by Matt on 11/16/2016.
 */

public class Movie_Children extends Movie {

    public Movie_Children(String title) {
        super(title);
    }

    @Override
    public double getRentalCost(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        frequentCustomerPoints = 1;
        return thisAmount;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 7;
    }
}
