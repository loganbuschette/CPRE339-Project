package com.example.matt.a339project.Objects.Merchandise.Movie;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public abstract class Movie implements Merchandise {

    private String movieTitle;
    protected int frequentCustomerPoints;

    public Movie(String title){
        this.movieTitle = title;
        this.frequentCustomerPoints = 0;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 10;
    }

    @Override
    public double getRentalCost(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        frequentCustomerPoints = 1;
        return thisAmount;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return frequentCustomerPoints;
    }

    @Override
    public String getItemTitle() {
        return movieTitle;
    }

}
