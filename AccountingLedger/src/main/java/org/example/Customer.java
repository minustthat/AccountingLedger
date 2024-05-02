package org.example;

 public class Customer {
    static double balance;

    public Customer(){

    }



    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        Customer.balance = balance;
    }
}
