package com.example.matt.a339project.Objects.Merchandise.Book;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public abstract class Book implements Merchandise {

    private String bookTitle;
    protected int frequentCustomerPoints;
    protected int daysRented;

    public Book(String title){
        this.bookTitle = title;
        this.frequentCustomerPoints = 0;
        daysRented = 0;
    }

    public Book(String title, int daysRented){
        this.bookTitle = title;
        this.frequentCustomerPoints = 0;
        this.daysRented = daysRented;
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public double getSaleCost() {
        frequentCustomerPoints = 2;
        return 5;
    }

    @Override
    public double getRentalCost() {
        frequentCustomerPoints = 1;
        return daysRented;
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
