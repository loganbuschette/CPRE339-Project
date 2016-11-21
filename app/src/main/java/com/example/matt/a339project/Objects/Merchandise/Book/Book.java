package com.example.matt.a339project.Objects.Merchandise.Book;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public abstract class Book implements Merchandise {

    private String bookTitle;
    protected int frequentCustomerPoints;

    public Book(String title){
        this.bookTitle = title;
        this.frequentCustomerPoints = 0;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 5;
    }

    @Override
    public double getRentalCost(int daysRented) {
        frequentCustomerPoints = 1;
        return 1 * daysRented;
    }

    @Override
    public int getFrequentCustomerPointCost(){
        return 20;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return frequentCustomerPoints;
    }

    @Override
    public String getItemTitle() {
        return bookTitle;
    }
}
