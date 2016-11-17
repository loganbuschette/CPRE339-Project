package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class Statement {

    private Transactions transactions;

    public Statement(Transactions transactions) {
        this.transactions = transactions;
    }

    public String getStatement() {
        String result = "Transaction Record for " + transactions.getCustomer().getName() + "\n";

        // go through each rental
        for (Transaction transaction : transactions.getCollection()) {
            result += "\t[" + (transaction.isRental() && transaction.isRental() ? "RENTED" : "BOUGHT") + "]  " + transaction.getMerchandise().getItemName() + ": $" + String.format("%.2f", transaction.getTransactionAmount()) + "\n";
        }

        // add footer lines
        result += "Amount owed before discounts is $" + String.format("%.2f", transactions.getTotalAmount()) + "\n";
        result += "Amount of discounts is $" + String.format("%.2f", transactions.bonusDiscount) + "\n";
        result += "Final balance is $" + String.format("%.2f", transactions.getFinalBalance()) + "\n";
        result += "You earned " + transactions.getTotalFrequentCustomerPoints() + " frequent renter points + " + transactions.bonusFrequentCustomerPoints + " bonus points.";

        return result;
    }
}
