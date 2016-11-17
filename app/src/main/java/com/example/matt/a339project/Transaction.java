package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public abstract class Transaction {

    public abstract boolean isRental();

    public abstract Merchandise getMerchandise();

    public abstract double getTransactionAmount();

    public abstract int getFrequentCustomerPoints();
}
