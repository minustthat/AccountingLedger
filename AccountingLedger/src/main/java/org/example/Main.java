package org.example;

import java.time.LocalTime;
import java.util.*;
import java.io.*;
import java.time.LocalDate;


    public class Main {
        // track all financial transaxctions for a business or for personal use.
        // all files should be read from and saved to a transaction file named transactions.csv
        // 3 Screens : Home (Add Deposit - prompt to , Make Payment - prompt , Ledger display screen, Exit),
        //             Ledger (All - display all , Deposits - into account , Payments - negative #s (left account,
        // Reports : month to date, previous month, year to date, previous year, search by vendor.
        // Back Home
        List<Customer> customers = new ArrayList<>();
        static StringBuilder fullSheet = new StringBuilder();

        private static void welcomeScreen() {
            LocalTime currentTime = LocalTime.now();
            File transactionFile = new File("transactions.csv");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to ! Please enter your name. ");
            String name = scanner.nextLine();
            Customer customer = new Customer();
            customer.setName(name);
            customer.setBalance(30.00);
            System.out.println(" Hello " + name + ". As a token of our appreciation, we have started you off with a " +
                    "balance of $30. \n Please choose one of the following: \n 1. Place New Transaction(s) \n 2" +
                    ". View Previous " +
                    "Transaction(s)");
            fullSheet.append(name + "|" );
            // name goes to stringbuilder to build sheet out.

            int choice = scanner.nextInt();
            while(choice != 3) {
                switch (choice) {
                    case 1:
                        System.out.println("Please choose one of the following options. \n 1. Deposit \n 2. Make Payment" +
                                "\n 3. View Ledger \n 4. Exit application. ");
                        String nextChoice = scanner.nextLine();

                        switch (nextChoice) {
                            case "A" : case  "a" :

                                // deposit screen

                                System.out.println("Your current balance is " + customer.getBalance() + " Please " +
                                        "enter amount " +
                                        "you would like to deposit.");
                                double depositAmount = scanner.nextDouble();
                                customer.setBalance(customer.getBalance() - depositAmount);

                                fullSheet.append(customer.getBalance() + "|");
                                break;


                            case "B": case "b":
                                // add money to account
                                System.out.println("Your current balance is: " + customer.getBalance() + ". How much would you " +
                                        "like to add? (Debit only)");
                                double amountAddedToBalance = scanner.nextDouble();
                                customer.setBalance(customer.getBalance() + amountAddedToBalance);
                                fullSheet.append(customer.getBalance()).append(currentTime);
                                System.out.println(fullSheet);
                                System.out.println("Your new balance is " + customer.getBalance() + ". Thank you.");
                                break;

//                case 3:
//                    try {
//
//                        FileInputStream reader = new FileInputStream(transactionFile);
//                        FileWriter writer = new FileWriter(transactionFile, true);
//                        // writing to the file
//                        writer.write(String.valueOf(fullSheet));
//                        // trying to read file
//                        Scanner readingScanner = new Scanner(transactionFile);
//                        readingScanner.useDelimiter("[|\\n]");
//                        while(readingScanner.hasNextLine()){
//                            System.out.println(scanner.nextLine());
//                        }
//                    } catch(Exception ex){
//
//                    }

                            // case 4 will be to close the application.
                        }
                        case 2:
                                // Ledger Screen : All entries, all deposits, all payments (negative entries), screen to run
                                // predefined reports , (Month to date, previous month, year to date, previous year

                                try {

                        FileInputStream reader = new FileInputStream(transactionFile);
                        FileWriter writer = new FileWriter(transactionFile, true);
                        // writing to the file
                        writer.write(String.valueOf(fullSheet));
                        // trying to read file
                        Scanner readingScanner = new Scanner(transactionFile);
                        readingScanner.useDelimiter("[|\\n]");
                        readingScanner.nextLine();
                        while(readingScanner.hasNextLine()){
                            System.out.println(fullSheet);
                        }
                    } catch(Exception ex){

                    }




                                }
            }

        }
        public static void main(String[] args) {
            welcomeScreen();

        }


}




