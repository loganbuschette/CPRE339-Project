package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Movie_NewRelease extends Movie{
    public Movie_NewRelease(String title) {
        super(title);
    }

    @Override
    public double getRentalCost(int daysRented) {
        return (double) 3 * daysRented;
    }

    @Override
    public int getFrequentCustomerPoints(int daysRented) {
        return (daysRented) > 1 ? 2 : 1;
    }

    @Override
    public double getSaleCost() {
        // TODO Auto-generated method stub
        return 14;
    }
}
