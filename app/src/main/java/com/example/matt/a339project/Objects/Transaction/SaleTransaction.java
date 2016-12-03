package com.example.matt.a339project.Objects.Transaction;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public class SaleTransaction extends Transaction {

    private Merchandise merchandise;
    private double saleCost;

    public SaleTransaction(Merchandise merchandise) {
        this.merchandise  = merchandise;
        saleCost = merchandise.getSaleCost();
    }

    @Override
    public Merchandise getMerchandise() {
        return merchandise;
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
