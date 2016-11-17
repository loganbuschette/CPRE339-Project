package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Book_Classic extends Book{

    public Book_Classic(String itemName) {
        super(itemName);
    }

    @Override
    public double getRentalCost(int daysRented) {
        double thisAmount = 1;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1;
        }
        return thisAmount;
    }

    @Override
    public int getFrequentCustomerPoints(int daysRented) {
        return 1;
    }

    @Override
    public double getSaleCost() {
        return 7;
    }
}
