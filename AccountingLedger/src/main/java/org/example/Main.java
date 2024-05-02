package org.example;
import java.time.LocalTime;
import java.util.*;
import java.io.*;


public class Main {

    static Customer customer = new Customer();
    static List<Transactions> transactions = new ArrayList<>();
    static List <Withdrawals> withdrawalList = new ArrayList<>();
    static List <Deposit> depositList = new ArrayList<>();


    private static void welcomeScreen() {
        LocalTime currentTime = LocalTime.now();
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome Dana, Please choose one of the following: \n 1. Place New Transaction(s) " +
                "\n 2. View Previous Transaction(s)");


        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 3) {
            switch (choice) {
                // writing to file , deposits & purchases
                // Placing new transactions :
                case 1:
                    System.out.println("Please choose one of the following options." +
                            "\n A. Deposit (debit only)  " +
                            "\n B. Take out money  " +
                            " \n C. Add a Recent Purchase " +
                            "\n D. Exit Application");
                    String nextChoice = scanner.nextLine();

                    switch (nextChoice) {
                        case "A":
                        case "a":
                            // deposit
                            depositCash(customer, scanner);

                            break;

                        case "B":
                        case "b":
                            // take out money
                            withdrawCash(scanner, customer);
                            System.out.println(transactions.size());
                            break;

                        case "C":
                        case "c":
                            // add new purchase
                            addPurchase(scanner);
                            System.out.println(transactions.size());
                            break;
                        case "D":
                        case "d":
                            // exit
                            welcomeScreen();
                            break;
                    }
                    break;
                // writing

                case 2:
                    // Viewing previous transactions
                    System.out.println("Which transactions would you like to view ? \n A. ALl \n B. Deposits \n C" +
                            ". " +
                            "Withdrawals / Purchases ");

                    String userChoice = scanner.nextLine();
                    scanner.nextLine();
                    switch (userChoice) {
                        case "A":
                        case "a":
                        readAllFromFile();

                            break;
                        case "B":
                        case "b":
                            welcomeScreen();
                            break;
                    }
                    break;


            }
        }
        // find past deposits   ;


    }

    private static void addPurchase(Scanner scanner) {
        Withdrawals withdrawal = new Withdrawals();
        System.out.println("What company did you purchase from?");
        String vendor = scanner.nextLine();
        withdrawal.setVendor(vendor);

        System.out.println("What did you buy?");
        String itemBought = scanner.nextLine();
        withdrawal.setItem(itemBought);
        System.out.println("How much did it cost? ");
        double itemPrice = scanner.nextDouble();
        withdrawal.setPrice(itemPrice);
        System.out.println(vendor + itemBought + "-" + itemPrice);
        withdrawal.setIsPurchase(true);
        transactions.add(withdrawal);
        System.out.println(withdrawal.printResultForPurchase());
        File transactionFile = new File("transactions.csv");
        try(FileWriter fileWriter = new FileWriter(transactionFile, true); ) {


          fileWriter.write(withdrawal.printResultForPurchase());
        fileWriter.flush();


        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
    }

    private static void withdrawCash(Scanner scanner, Customer customer) {
        System.out.println("How much did you take out? ");
        double withdrawalAmount = scanner.nextDouble();
        customer.setBalance(customer.getBalance() - withdrawalAmount);
        Withdrawals newWithdrawl = new Withdrawals();
        newWithdrawl.setTransactionAmount(withdrawalAmount);
        scanner.nextLine();
        newWithdrawl.addWithdrawal(withdrawalAmount);
        transactions.add(newWithdrawl);
        writeToFile(newWithdrawl);
        System.out.println("Noted. Balance after deposit : " + customer.getBalance() + ".");
        return;
    }

    private static void depositCash(Customer customer, Scanner scanner) {
        System.out.println("Your current balance is: " + customer.getBalance() + ". How much would you " +
                "like to deposit? (Debit only)");
        Deposit deposit = new Deposit();
        deposit.setCurrentBalance(customer.getBalance());
        double depositAmount = scanner.nextDouble();
        deposit.setTransactionAmount(depositAmount);
        scanner.nextLine();
        customer.setBalance(customer.getBalance() + depositAmount);

        deposit.addDeposit(depositAmount);
        deposit.setCurrentBalance(customer.getBalance());
        transactions.add(deposit);
        depositList.add(deposit);
        writeToFile(deposit);
        System.out.println(deposit.printResult());
        return;

    }



    public static void writeToFile(Transactions transactions) {
        try {

            File transactionFile = new File("transactions.csv");
            FileWriter fileWriter = new FileWriter(transactionFile, true);
            PrintWriter pw = new PrintWriter(fileWriter);

                pw.println(transactions.printResult().toString());


            pw.close();

        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
    }

    public static void writePurchaseToFile(Withdrawals newWithdrawal) {
        try {

            File transactionFile = new File("transactions.csv");
            FileWriter fileWriter = new FileWriter(transactionFile, true);
            PrintWriter pw = new PrintWriter(fileWriter);

            pw.println(newWithdrawal.printResultForPurchase());


            pw.close();

        } catch (IOException e) {
            System.out.println("Can't find file.");
        } catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    public static void readAllFromFile() {
        try {
            File transactionFile = new File("transactions.csv");
            FileReader fileReader = new FileReader(transactionFile);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while((line = br.readLine()) != null){
               String[] cols = line.split("\\|");

               Transactions transaction = new Transactions();
               transactions.add(transaction);
            }


        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
    }

//    public static void readDeposits(){
//        try {
//            File transactionFile = new File("transactions.csv");
//            FileReader fileReader = new FileReader(transactionFile);
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while((line = br.readLine()) != null){
//                for (Deposit deposit : depositList) {
//                   data.add(deposit.printResult().toString());
//                }
//            }
//
//
//        } catch (IOException e) {
//            System.out.println("Can't find file.");
//        }
//    }


    public static void main(String[] args) {
        welcomeScreen();

    }

}





