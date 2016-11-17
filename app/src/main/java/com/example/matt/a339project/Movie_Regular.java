package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Movie_Regular extends Merchandise {

    public Movie_Regular(String title) {
        super(title);
    }

    @Override
    public double getRentalCost(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }

    @Override
    public int getFrequentCustomerPoints(int daysRented) {
        return 1;
    }

    @Override
    public double getSaleCost() {
        // TODO Auto-generated method stub
        return 10;
    }
}
