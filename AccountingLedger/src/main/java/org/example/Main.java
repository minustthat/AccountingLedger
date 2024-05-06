package org.example;
import java.lang.reflect.Array;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.io.*;


public class Main {

    // Get the current system date
    static LocalDate localDate = LocalDate.now();
static LocalTime localtime = LocalTime.now();
 static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("kk:mm:ss");
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 static String dateFormatted = localDate.format(formatter);
 static String timeFormatted = localtime.format(timeFormat);
    // Convert to a string


    static Customer customer = new Customer();
    static List<Transactions> transactions = new ArrayList<>();
    static List <Withdrawals> withdrawalList = new ArrayList<>();
    static List <Deposit> depositList = new ArrayList<>();
    // use setDate on transactions, format, use getDate on transactions classes

    private static void welcomeScreen() {
        LocalTime currentTime = LocalTime.now();
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("""
                                                                                         
                                                                                         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                                ⠀⠀⢠⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⡄⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                        ⠀⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠉⠁⠀⠀⠈⠙⠻⢦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                     ⣀⣴⠶⠚⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                         
                                                                   ⣠⡞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠓⠒⠒⠒⠶⣦⣄⠀⠀⠀
                                                                  ⢰⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣄⠀
                                                                 ⣠⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣆
                                                               ⣴⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿
                                                              ⣸⠃Welcome Dana, Please choose one of the following: \n 
                                                                         1. Place New Transaction(s) \n 
                                                                           2. View Previous Transaction(s)⠀⠀⠀⠀
                                                                             3. See Reports ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿
                                                              ⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠿
                                                              ⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠀
                                                               ⠻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠶⠤⠶⠶⠛⠉⠀⠀⠀
                                                                ⠈⠛⠶⠶⠤⠴⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                      ⢹⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                       ⠹⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                    ⢠⣴⠶⠶⣾⡻⣦⣀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                                ⣿⠀⠀⠀⠈⣷⠀⠉⠙⠛⠒⠒⠒⠛⠋⠁⠀⠈⠛⠳⠦⣤⣤⣤⣤⣤⡴⠶⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                             ⣠⣤⣄⢻⣦⣀⣀⣴⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                             ⠸⣏⠀⢹⡇⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                       
                             <((((((\\\\\\
                             /      . }\\           ⢰⣟⣿⠙⣛⣋⠀⠀
                            ;--..--._|}     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        (\\                 '--/\\--'  )
         \\\\                | '-'  :'|
          \\\\               . -==- .-|
           \\\\               \\.__.'   \\--._
           [\\\\          __.--|       //  _/'--.
           \\ \\\\       .'-._ ('-----'/ __/      \\
            \\ \\\\     /   __>|      | '--.       |
             \\ \\\\   |   \\   |     /    /       /
              \\ '\\ /     \\  |     |  _/       /
               \\  \\       \\ |     | /        /
             \\  \\      \\        / 
        """);

        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 5) {
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
                            break;

                        case "C":
                        case "c":
                            // add new purchase
                            addPurchase(scanner);
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
                    pastTransactionsScreen(scanner);
                    break;


                case 3:

                    System.out.println("""
                            Which search would you like to conduct? \n
                            1.Month to Date \n 
                            2.Previous month \n
                            3.Year to date \n
                            4.Previous Year \n
                            5.Search by vendor 
                            6. Go back to reports screen""" );
                    int Choice = scanner.nextInt();
                    scanner.nextLine();
                    switch(Choice){
                        case 1:

                            // month to date search
                           monthToDate();
                            break;
                        case 2:
                            // previous month


                        case 3:
                            // previous year search

                        case 4:
                            // previous year search

                        case 5:
                            searchByVendor();
                            break;
                        case 6:
                            // back to reports screen
                            welcomeScreen();

                    }
            }
        }
        // find past deposits   ;


    }

    private static void pastTransactionsScreen(Scanner scanner) {
        System.out.println("Which transactions would you like to view ? \n 1. ALl \n 2. Deposits \n 3" +
                ". " +
                "Withdrawals / Purchases + " + "\n" + "4. Home Screen ");

        int userChoice = scanner.nextInt();
        scanner.nextLine();
        switch (userChoice) {

            case 1:
            readTransactions();
                break;
            case 2:
                readDeposits();
                break;
            case 3:
                readWithdrawals();
                break;
            case 4:
                welcomeScreen();
        }
    }

    private static void addPurchase(Scanner scanner) {
        System.out.println("What company did you purchase from?");
        String vendor = scanner.nextLine();
        Withdrawals withdrawal = new Withdrawals();
        withdrawal.setVendor(vendor);
        System.out.println("What did you buy?");
        String itemBought = scanner.nextLine();
        withdrawal.setItem(itemBought);
        System.out.println("How much did it cost? ");
        double itemPrice = scanner.nextDouble();
        withdrawal.setTransactionAmount(itemPrice);
        withdrawal.setTime(LocalTime.parse(timeFormatted));
        withdrawal.setDate(LocalDate.now());
        withdrawal.setVendor(vendor);
        withdrawal.setDescription(itemBought);
        scanner.nextLine();
        System.out.println(vendor + itemBought + "-" + itemPrice);
        transactions.add(withdrawal);
        withdrawalList.add(withdrawal);
        System.out.println(withdrawal.printResultForPurchase());
        File transactionFile = new File("transactions.csv");
        try(FileWriter fileWriter = new FileWriter(transactionFile, true); ) {

          fileWriter.write(withdrawal.printResultForPurchase());
        fileWriter.flush();


        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
return;
    }

    private static void withdrawCash(Scanner scanner, Customer customer) {
        System.out.println("How much did you take out? ");
        double withdrawalAmount = scanner.nextDouble();
        Withdrawals newWithdrawl = new Withdrawals();
        newWithdrawl.setPrice(withdrawalAmount);
        newWithdrawl.setDescription("Mobile");
        scanner.nextLine();
        writeWithdrawal(newWithdrawl);
        newWithdrawl.setVendor("Mobile");
        newWithdrawl.setDate(LocalDate.now());
        newWithdrawl.setTime(LocalTime.parse(timeFormatted));
        newWithdrawl.setTransactionAmount(withdrawalAmount);
        transactions.add(newWithdrawl);
        withdrawalList.add(newWithdrawl);
        System.out.println("Noted.");
        File transactionFile = new File("transactions.csv");
        try(FileWriter fileWriter = new FileWriter(transactionFile, true); ) {

            fileWriter.write(newWithdrawl.printPurchase());
            fileWriter.flush();


        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
        return;
    }

    private static void depositCash(Customer customer, Scanner scanner) {
        System.out.println("How much would you like to deposit? (Debit only)");
        Deposit deposit = new Deposit();

        double depositAmount = scanner.nextDouble();
        deposit.setTransactionAmount(depositAmount);
        scanner.nextLine();
        customer.setBalance(customer.getBalance() + depositAmount);

        deposit.setTransactionAmount(depositAmount);

        transactions.add(deposit);
        depositList.add(deposit);
        deposit.setDate(LocalDate.now());
        deposit.setTime(LocalTime.parse(timeFormatted));
        deposit.setVendor("deposit");
        deposit.setDescription("Mobile");
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
    public static void writeWithdrawal(Withdrawals newWithdrawal){
        try {

            File transactionFile = new File("transactions.csv");
            FileWriter fileWriter = new FileWriter(transactionFile, true);
            PrintWriter pw = new PrintWriter(fileWriter);

            pw.println(newWithdrawal.printResult());


            pw.close();

        } catch (IOException e) {
            System.out.println("Can't find file.");
        }
        return;
    }

    public static void readTransactions(){
        File transactionFile = new File("transactions.csv");
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(transactionFile));
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
        }catch(IOException e){

        }
    }
    public static void readDeposits() {
        Scanner scanner = new Scanner(System.in);

        File transactionFile = new File("transactions.csv");

        try(BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            String line = reader.readLine();


            while ((line = reader.readLine()) != null) {
                String[] cols = line.split("[|]");

                if (cols.length >= 4) {
                    double depositAmount = Double.parseDouble(cols[3]);

                    if (depositAmount > 0) {
                        System.out.println(line);
                    }
                }
            }
        }catch(IOException e){
        }
    }
    public static void readWithdrawals(){
            Scanner scanner = new Scanner(System.in);
            File transactionFile = new File("transactions.csv");

            try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split("[|]");

                    if (columns.length >= 4) {
                        double depositAmount = Double.parseDouble(columns[3]);
                        if (depositAmount < 0) {
                            System.out.println(line);
                        }
                    }

                }
            } catch (IOException ex) {
                System.out.println("ERROR ABORT IMMEDIATELY ABORT ABORT ABORT PLEASE ");
            }

        }

    public static void monthToDate(){
        String file = "transactions.csv";


        LocalDate transactionDate;

        int CurrentMonth = localDate.getMonthValue();
        int CurrentYear = localDate.getYear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String line;


            while ((line = reader.readLine()) != null) {
                String[] cols = line.split("[|]");
                transactionDate = LocalDate.parse(dateFormatted);
                if (transactionDate.getMonthValue() == CurrentMonth && transactionDate.getYear() == CurrentYear) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not read.");
        }


    }
    public static void searchByVendor() {
        String transactionFile = "transactions.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the vendor name below: ");
        String vendorName = scanner.nextLine();
        System.out.println();

        try (BufferedReader reader = new BufferedReader(new FileReader(transactionFile))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] cols = line.split("[|]");
                String vendor = cols[3];

                if (vendor.equalsIgnoreCase(vendorName)) {
                    System.out.println(line);
                }
            }

        } catch (IOException e){
            }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ABORT SOMETHING HAS GONE COMPLETELY WRONG ");
        }
    }
        public static void main(String[] args) {
        welcomeScreen();

    }



}





