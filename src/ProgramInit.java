import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramInit extends Programs {

    public static void main (String []args) throws InterruptedException {
       mainMenu();
    }

    public static void mainMenu() throws InterruptedException {

        Programs p = new Programs();

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
        p.clearConsole();
        int application = 0;

        switch(input){
            case 1:
                p.clearConsole();
                System.out.println("\n****************************************");
                System.out.println("Receipt Text Registrator");
                System.out.println("****************************************");
                Thread.sleep(1000);
                application = 1;
                p.programInit(application);
                break;

            case 2:
                System.out.println("\n****************************************");
                System.out.println("Order Registrator");
                System.out.println("****************************************");
                Thread.sleep(1000);
                application = 2;
                p.programInit(application);
                break;

            case 3:
                System.out.println("\n****************************************");
                System.out.println("Bills Registrator");
                System.out.println("****************************************");
                Thread.sleep(1000);
                application = 3;
                p.programInit(application);
                break;

            case 4:
                System.out.println("Shutting down...");
                Thread.sleep(2000);
                p.clearConsole();
                System.exit(0);
        }
    }






}
