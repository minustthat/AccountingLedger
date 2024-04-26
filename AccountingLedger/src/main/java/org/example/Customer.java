package org.example;

public class Customer {
     String  name;
    double balance;


    public Customer(String name,  double balance){
        this.name = name;
        this.balance = balance;
    }

    public Customer(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
