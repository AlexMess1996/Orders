import java.util.Scanner;

public class ProgramInit extends Programs {

    public static void main (String []args) throws InterruptedException {
       mainMenu();
    }

    public static void mainMenu() throws InterruptedException {

        clearConsole();
        System.out.println("****************************************");
        System.out.println("Main Menu:");
        System.out.println("Choose the following to use: ");
        System.out.println("1: Print to .txt files receipts");
        System.out.println("2: Calculate and print orders");
        System.out.println("3: Calculate and print bills");
        System.out.println("4: Exit");
        System.out.println("****************************************");
        System.out.print("Your input: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        clearConsole();
        int application;

        switch (input) {
            case 1 -> {
                clearConsole();
                System.out.println("\n****************************************");
                System.out.println("Receipt Text Register");
                System.out.println("****************************************");
                System.out.println("Loading...");
                Thread.sleep(1500);
                application = 1;
                programInit(application);
            }
            case 2 -> {
                System.out.println("\n****************************************");
                System.out.println("Order Register");
                System.out.println("****************************************");
                System.out.println("Loading...");
                Thread.sleep(1500);
                application = 2;
                programInit(application);
            }
            case 3 -> {
                System.out.println("\n****************************************");
                System.out.println("Bills Register");
                System.out.println("****************************************");
                System.out.println("Loading...");
                Thread.sleep(1500);
                application = 3;
                programInit(application);
            }
            case 4 -> {
                System.out.println("Shutting down...");
                Thread.sleep(2000);
                clearConsole();
                System.exit(0);
            }
        }
    }






}
