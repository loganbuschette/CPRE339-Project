package com.example.matt.a339project;

import com.example.matt.a339project.Objects.Merchandise.Movie.Movie_NewRelease;
import com.example.matt.a339project.Objects.Transaction.Transaction;
import com.example.matt.a339project.Objects.Merchandise.Transactions;

/**
 * Created by Matt on 11/16/2016.
 */

public class OperationYoungNewRelease implements EndSaleStrategy {
    @Override
    public void applyAction(Transactions transactions) {
        if (transactions.getCustomer().getAge() >= 18 && transactions.getCustomer().getAge() <= 22) {
            for(Transaction t : transactions.getCollection()) {
                if (t.getMerchandise().getClass().equals(Movie_NewRelease.class)) {
                    transactions.bonusFrequentCustomerPoints = transactions.getTotalFrequentCustomerPoints();
                }
            }
        }
    }
}
