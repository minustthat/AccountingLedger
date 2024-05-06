package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Transactions {
    String type;
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now() ;
    String description;

String vendor;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    double transactionAmount;

    public Transactions(LocalDate date, LocalTime time, String vendor, int transactionAmount) {
    }


    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Transactions() {

    }

    public Transactions(LocalDate date, String type, String vendor, double amount){
        this.date = date;
        this.type = type;

    }


    public void setDescription(String description) {
        this.description = description;
    }

    String printResult(){
            return getDate() + " | " + getTime() + " | " + getDescription() + type + "|" + getTransactionAmount() +
                    "\n";
        }





    public void setDate(Date date) {

    }


}
