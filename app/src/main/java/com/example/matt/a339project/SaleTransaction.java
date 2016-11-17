package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class SaleTransaction extends Transaction {

    private Merchandise _merchandise;
    private double saleCost;

    public SaleTransaction(Merchandise merchandise) {
        _merchandise  = merchandise;
        saleCost = merchandise.getSaleCost();
    }

    @Override
    public Merchandise getMerchandise() {
        return _merchandise;
    }

    @Override
    public boolean isRental() {
        return false;
    }

    @Override
    public double getTransactionAmount() {
        return saleCost;
    }

    @Override
    public int getFrequentCustomerPoints() {
        return 0;
    }
}
