package com.example.matt.a339project.Objects.Transaction;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public class RentalTransaction extends Transaction {
    private Merchandise merchandise;
    private int   daysRented;
    private double rentalCost;
    private int frequentCustomerPoints;

    public RentalTransaction(Merchandise merchandise, int daysRented) {
        this.merchandise  = merchandise;
        this.daysRented = daysRented;
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
