package com.example.matt.a339project.Objects.Merchandise.Book;

import com.example.matt.a339project.Objects.Merchandise.Book.Book;

/**
 * Created by Matt on 11/16/2016.
 */

public class Book_Classic extends Book {

    public Book_Classic(String itemName) {
        super(itemName);
    }

    @Override
    public double getRentalCost(int daysRented) {
        double thisAmount = 1;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1;
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
