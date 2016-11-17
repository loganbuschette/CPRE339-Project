package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Customer {
    private String _name;
    private int _age;
    private Transactions transactions;

    public Customer (String name, int age) {
        _name = name;
        _age = age;
        this.transactions = new Transactions(this);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void finalizeTransactions() {
        transactions.applyEndSaleStrategies();
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    public String printStatement() {
        Statement statement = transactions.getStatement();
        return statement.getStatementAsText();
    }
}
