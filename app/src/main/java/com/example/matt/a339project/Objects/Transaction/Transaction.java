package com.example.matt.a339project.Objects.Transaction;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

/**
 * Created by Matt on 11/16/2016.
 */

public abstract class Transaction {

    public abstract boolean isRental();

    public abstract Merchandise getMerchandise();

    public abstract double getTransactionAmount();

    public abstract int getFrequentCustomerPoints();
}
