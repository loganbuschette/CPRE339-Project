package com.example.matt.a339project.Objects.Merchandise.Movie;

public class Movie_Children extends Movie {

    public Movie_Children(String title) {
        super(title);
    }

    public Movie_Children(String title, int daysRented){ super(title, daysRented);}

    @Override
    public double getRentalCost() {
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

    @Override
    public int getFrequentCustomerPointCost(){
        return 15;
    }
}
