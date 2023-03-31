import java.io.FileOutputStream;
import java.util.Scanner;

public class main {
    public static void main(String []args){
        print();
    }

    public static void print() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Amount of orders:");
        int amount = scanner.nextInt();

        System.out.println("Kilometers:");
        double km = scanner.nextDouble();

        System.out.println("Type of day: (Type the number you want to choose below...)");
        System.out.println("1: Weekday");
        System.out.println("2: Saturday");
        System.out.println("3: Sunday");

        System.out.print("Your input: ");
        int type = scanner.nextInt();

        System.out.println("Total earned for this delivery: " + sum(amount, km, type));

        try {
            String filePath = "C:\\Users\\bruker\\Desktop\\demo.txt";
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
            String lineToAppend = "\r\nDelivery: " + "" + sum(amount, km, type);
            byte[] byteArr = lineToAppend.getBytes(); // converting string into byte array
            fileOutputStream.write(byteArr);
            fileOutputStream.close();
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
}