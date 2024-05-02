package org.example;

import java.util.Date;

import static org.example.Main.customer;

public class Withdrawals extends Transactions {
static boolean isPurchase;
String vendor;
double price;
String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    Withdrawals(double priorBalance, double amountAfterOperation, String type, Date date, boolean isPurchase
                ) {
        super(priorBalance, amountAfterOperation, type, date);


    }

    Withdrawals(){
        super();
        this.type = "Withdrawal";
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean purchase) {
        isPurchase = purchase;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    String printResultForPurchase(){
        return date + " | " + "Vendor : " + vendor + " | Price : " + price + " | Prior Balance : " + priorBalance +
                " | current " +
                "balance : " +
                (customer.getBalance() - price);
    }

    public static void setIsPurchase(boolean isPurchase) {
        Withdrawals.isPurchase = isPurchase;
    }

    double addWithdrawal(double amount) {
        priorBalance = Customer.getBalance() + transactionAmount;
        currentBalance = Customer.getBalance() - transactionAmount;
        return currentBalance;
    }

    double addPurchase(){
        isPurchase = true;
        priorBalance = Customer.getBalance() + transactionAmount;
        currentBalance = Customer.getBalance() - transactionAmount;
        return currentBalance;
    }

    String printPurchase() {
        return date +  "Type : Withdrawl" + "Vendor : " + getVendor() + " | " + " Previous balance : " + getPriorBalance() + " |" +
                " " +
                " New " +
                "Balance :" +
                " " + getCurrentBalance() +
                "\n";
    }
}
