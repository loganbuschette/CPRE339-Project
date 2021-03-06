package com.example.matt.a339project.Objects.Merchandise.Book;

public class Book_Classic extends Book {

    public Book_Classic(String title) {
        super(title);
    }

    public Book_Classic(String title, int daysRented){ super(title, daysRented);}

    @Override
    public double getRentalCost() {
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
