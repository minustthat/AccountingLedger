package org.example;

import java.util.Date;


public class Deposit extends Transactions {


    Deposit() {
        super();
        this.type = "Deposit";

    }

    double addDeposit(double amount) {
        priorBalance = Customer.getBalance() - transactionAmount;
        currentBalance = Customer.getBalance() + transactionAmount;
        return currentBalance;
    }
}






