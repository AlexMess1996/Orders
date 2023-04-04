import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programs {

    public static int programInit(int var) throws InterruptedException {
        boolean retry = true;
        while (retry == true){
            if(var == 1){
                registerReceipt();
            } else if(var==2){
                orderCalculator();
            }else if(var==3){
                registerBills();
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to continue?    Y/N");
            char input = sc.next().charAt(0);

            if(input == 'Y' || input == 'y'){
                retry = true;
                clearConsole();
            }else if(input == 'N' || input == 'n'){
                retry = false;
                System.out.println("Returning to the Main Menu...");
                Thread.sleep(1000);
                clearConsole();
                ProgramInit.mainMenu();
            }
        }
        System.out.println("Have a good day!");
        return 0;
    }

    public static void registerBills() throws InterruptedException {

        clearConsole();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the data from the faktura");
        System.out.print("Amount of desired bills you want to register: ");
        int amount = sc.nextInt();
        //Arrays
        double[] prices = {};
        prices = new double[amount];
        String[] companyName = {};
        companyName = new String[amount];
        String[] date = {};
        date = new String[amount];
        String[] kidNumber = {};
        kidNumber = new String[amount];
        String[] typeOfBill = {};
        typeOfBill = new String[amount];
        String[] accNumbers = {};
        accNumbers = new String[amount];
        //End Arrays

        //Storing data to Array
        String redundantDate = "";
        for (int i = 0; i < amount; i++) {
            if (i < 1) {
                System.out.print("Date: ");
                String dateBill = sc.next();
                redundantDate = dateBill;
                date[i] = dateBill;
            } else {
                date[i] = redundantDate;
            }
            System.out.print("Company Name: ");
            String compName = sc.next();
            companyName[i] = compName;
            System.out.print("Category: ");
            String typeBill = sc.next();
            typeOfBill[i] = typeBill;
            System.out.print("Account Number: ");
            String accNumber = sc.next();
            accNumbers[i] = accNumber;
            System.out.print("KID: ");
            String kidNr = sc.next();
            kidNumber[i] = kidNr;
            System.out.print("Price: ");
            double price = sc.nextDouble();
            prices[i] = price;
        }
        //end storing
        writeBillsToTxt(amount,date,companyName,typeOfBill,accNumbers,kidNumber,prices);
        for (int j = 0; j<prices.length; j++){
        }
        Thread.sleep(1000);
        System.out.println("Information stored!");
        System.out.println("****************************************");
    }
    public static void writeBillsToTxt(int amount, String [] date, String [] companyName, String [] typeOfBill,String [] accountNumber, String [] kidNumber, double [] price){
        try{
            double sum = 0;
            String filePath = "C:\\Users\\bruker\\Desktop\\bills.txt";
            FileOutputStream f = new FileOutputStream(filePath, true);
            for(int k = 0; k<price.length; k++){
                sum += price[k];
            }

            for(int i = 0; i<amount; i++){
                String lineToAppend = "\n"+date[i]+": "+companyName[i]+": "+typeOfBill[i]+": "+kidNumber[i]+": "+price[i]+" NOK";
                byte[] byteArr = lineToAppend.getBytes();
                f.write(byteArr);
                if(i == amount-1){
                    lineToAppend = "\n"+"Sum: "+sum+" NOK";
                    byteArr = lineToAppend.getBytes();
                    f.write(byteArr);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    //end registering bills

    private static Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    private static Pattern PRICE_PATTERN = Pattern.compile("[0-9]");

    public static void writeRecieptToTxt(int prodAmount,String [] date,String [] prodName,String [] prodLocation, double [] prodPrice){
        try
        {
            double sum = 0;
            String filePath = "C:\\Users\\bruker\\Desktop\\kvittering.txt";
            FileOutputStream f = new FileOutputStream(filePath, true);
            for(int k = 0; k<prodPrice.length; k++){
                sum += prodPrice[k];
            }
            for(int i = 0 ; i< prodAmount; i++){
                String lineToAppend = "\n"+date[i]+": "+prodLocation[i]+": "+prodName[i]+": "+prodPrice[i]+" NOK";
                byte[] byteArr = lineToAppend.getBytes();
                f.write(byteArr);
                if(i == prodAmount-1){
                    lineToAppend = "\n"+"Sum: "+sum+" NOK";
                    byteArr = lineToAppend.getBytes();
                    f.write(byteArr);
                }
            }
            f.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void registerReceipt() throws InterruptedException {

        boolean matchDate = true;
        boolean matchPrice = true;
        boolean datematch;
        boolean priceMatch;

        String date = "";
        double prodPrice = 0.0;
        clearConsole();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the data from the receipt: ");
        Thread.sleep(1000);
        System.out.print("Amount of purchased products: ");
        int prodAmount = sc.nextInt();
        clearConsole();
        //Arrays
        double [] prodPriceArray  = {};
        prodPriceArray = new double[prodAmount];
        String [] prodNameArray = {};
        prodNameArray = new String[prodAmount];
        String [] purchaseDateArray ={};
        purchaseDateArray = new String[prodAmount];
        String [] prodLocationArray = {};
        prodLocationArray = new String[prodAmount];
        //End Arrays

        //Storing data to arrays
        String redundantDate = "";
        String redundantLoc = "";
        for(int i = 0; i<prodAmount; i++){
            if(i<1){
                System.out.print("Product 1: \nDate: ");
                while(matchDate){
                    date = sc.next();
                    datematch = DATE_PATTERN.matcher(date).matches();
                    if(datematch){
                        matchDate = false;
                    }else{
                        System.out.println("Re-enter the date. Format: dd/mm/yyyy");
                        System.out.println("Date: ");
                    }
                }
                redundantDate = date;
                purchaseDateArray[i] = date;
            }else{
                System.out.println("Product "+(i+1));
                purchaseDateArray[i] = redundantDate;
            }
            if(i<1){
                System.out.print("Location: ");
                String prodLocation = sc.next();
                redundantLoc = prodLocation;
                prodLocationArray[i] = prodLocation;
            }else{
                prodLocationArray[i] = redundantLoc;
            }
            System.out.print("Product Name: ");
            String prodName = sc.next();
            prodNameArray[i] = prodName;
            System.out.print("Price: ");

            while(matchPrice){
                String checkPrice = sc.next();
                Matcher matcher = PRICE_PATTERN.matcher(checkPrice);
                priceMatch = matcher.find();
                if(priceMatch){
                    matchPrice = false;
                    prodPrice = Double.parseDouble(checkPrice);
                }else{
                    System.out.println("Your input doesn't include a number. Please try again!");
                    System.out.print("Price: ");
                }
            }
            matchPrice = true;
            prodPriceArray [i]= prodPrice;
            clearConsole();
        }
        //End Storing
        //writes data in a .txt file
        writeRecieptToTxt(prodAmount,purchaseDateArray,prodNameArray,prodLocationArray,prodPriceArray);
        for (int j = 0; j<prodPriceArray.length; j++){
        }
        System.out.println("Information stored!");
        Thread.sleep(1000);
        System.out.println("****************************************");
    }

    public static void orderCalculator() {
        clearConsole();
        Scanner sc = new Scanner(System.in);
        System.out.println("Amount of orders:");
        int amount = sc.nextInt();
        System.out.println("Kilometers: ");
        double km = sc.nextDouble();
        System.out.println("Type of day: (Type the number you want to choose below...)");
        System.out.println("1: Weekday");
        System.out.println("2: Saturday");
        System.out.println("3: Sunday");
        System.out.println("Your input: ");
        int type = sc.nextInt();
        System.out.println("Total earned for this delivery: " + sum(amount, km, type));
        try {
            String filePath = "C:\\Users\\bruker\\Desktop\\orders.txt";
            FileOutputStream f = new FileOutputStream(filePath, true);
            String lineToAppend = "\r\nDelivery: " + "" + sum(amount, km, type);
            byte[] byteArr = lineToAppend.getBytes(); //converting string into byte array
            f.write(byteArr);
            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static double sum(int amount, double km, int type) {

        double pricePerOrder = 0;
        double totalPricePerOrder;
        double pricePerKm;
        double sum;
        if (type == 1) {
            pricePerOrder = 16.4;
        } else if (type == 2) {
            pricePerOrder = 21.4;
        } else if (type == 3) {
            pricePerOrder = 26.4;
        }
        totalPricePerOrder = pricePerOrder * amount;
        pricePerKm = km * 2.4;
        sum = totalPricePerOrder + pricePerKm;

        return sum;
    }
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
