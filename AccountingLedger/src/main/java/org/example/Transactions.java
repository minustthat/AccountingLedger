package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Transactions {
    static double priorBalance;

    double currentBalance;
    String type;
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();



    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    double transactionAmount;
    public Transactions() {

    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    String printResult(){
            return date + " | " + type + " | " + " Previous balance : " + getPriorBalance() + " | " + " " +
                    "New " +
                    "Balance :" +
                    " " + Customer.getBalance() +
                "\n";
        }

Transactions(double priorBalance, double amountAfterOperation, String type, Date date){
            this.priorBalance = priorBalance;
            this.currentBalance = amountAfterOperation;
            this.type = type;

}

    public double getPriorBalance() {
        return priorBalance;
    }

    public static void setPriorBalance(double priorBalance) {
        Transactions.priorBalance = priorBalance;
    }


    public void setCurrentBalance(double amountAfterOperation) {
        this.currentBalance = amountAfterOperation;
    }



    public void setDate(Date date) {

    }
}
