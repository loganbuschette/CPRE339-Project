package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Customer {
    private String name;
    private int age;
    private Transactions transactions;

    public Customer (String name, int age) {
        this.name = name;
        this.age = age;
        this.transactions = new Transactions(this);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void finalizeTransactions() {
        transactions.applyEndSaleStrategies();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String printStatement() {
        Statement statement = transactions.getStatement();
        return statement.getStatement();
    }
}
