package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class RentalTransaction extends Transaction {
    private Merchandise merchandise;
    private int   daysRented;
    private double rentalCost;
    private int frequentCustomerPoints;

    public RentalTransaction(Merchandise merchandise, int daysRented) {
        this.merchandise  = merchandise;
        this.daysRented = daysRented;
        rentalCost = merchandise.getRentalCost(daysRented);
        frequentCustomerPoints = merchandise.getFrequentCustomerPoints(daysRented);
    }

    @Override
    public Merchandise getMerchandise() {
        return merchandise;
    }

    @Override
    public boolean isRental() {
        return true;
    }

    @Override
    public double getTransactionAmount() {
        return rentalCost;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return frequentCustomerPoints;
    }

    public int getDaysRented() {
        return daysRented;
    }


}
