package com.example.matt.a339project;

import com.example.matt.a339project.Objects.Customer.Customer;
import com.example.matt.a339project.Objects.Transaction.Transaction;
import com.example.matt.a339project.Objects.Statement.Statement;

import java.util.ArrayList;

/**
 * Created by Matt on 11/16/2016.
 */

public class Transactions {

    private ArrayList<Transaction> transactionCollection = new ArrayList<>();
    private Customer customer;
    private double totalAmount = 0;
    private int totalFrequentCustomerPoints = 0;
    protected double bonusDiscount = 0;
    protected int bonusFrequentCustomerPoints = 0;

    public Transactions(Customer customer) {
        this.customer = customer;
    }

    public void add(Transaction transaction) {
        transactionCollection.add(transaction);

        // calculate amount and frequent renter points
        totalAmount += transaction.getTransactionAmount();
        totalFrequentCustomerPoints += transaction.getFrequentCustomerPoints();
    }

    public ArrayList<Transaction> getCollection() {
        return transactionCollection;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getFinalBalance() {
        return totalAmount - bonusDiscount;
    }

    public int getTotalFrequentCustomerPoints() {
        return totalFrequentCustomerPoints;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Statement getStatement() {
        return null;
        //new Statement(this);
    }

}
