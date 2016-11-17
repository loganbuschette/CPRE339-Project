package com.example.matt.a339project;

/**
 * Created by Matt on 11/16/2016.
 */

public class OperationBulkDiscount implements EndSaleStrategy {

    @Override
    public void applyAction(Transactions transactions) {

        double totalPurchasedCost = 0;
        int numRentedItems = 0;

        for(Transaction t : transactions.getCollection()) {
            if (t.isRental()) {
                numRentedItems++;
            } else {
                totalPurchasedCost += t.getTransactionAmount();
            }
        }

        if (numRentedItems >= 3 && numRentedItems <= 5) {
            transactions.bonusDiscount =  .2 * totalPurchasedCost;
        } else if (numRentedItems > 5) {
            transactions.bonusDiscount =  .5 * totalPurchasedCost;
        }
    }
}
