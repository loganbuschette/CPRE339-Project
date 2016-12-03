package com.example.matt.a339project.Objects.Transaction;

import com.example.matt.a339project.Objects.Merchandise.Merchandise;

public abstract class Transaction {

    public abstract boolean isRental();

    public abstract Merchandise getMerchandise();

    public abstract double getTransactionAmount();

    public abstract int getFrequentCustomerPoints();
}
