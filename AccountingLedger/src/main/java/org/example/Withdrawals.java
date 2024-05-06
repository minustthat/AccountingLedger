package org.example;


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
        return getDate() + "|" + getTime() + "|"  + getVendor() + " " + getDescription() + "|" + (getTransactionAmount() * -1) +
                "\n";
    }

    public static void setIsPurchase(boolean isPurchase) {
        Withdrawals.isPurchase = isPurchase;
    }


    String printPurchase() {
        return getDate() + "|" + getTime() + "|"  + getVendor() + " " + getDescription() + "|" + (getTransactionAmount() * -1) +
                "\n";
    }
}
