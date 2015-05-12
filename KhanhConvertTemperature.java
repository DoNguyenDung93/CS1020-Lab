// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex1
// Name: Dao Gia Khanh
// Matric. No.: a0126493b
// Lab group: 5
// The program take in temperature and convert them into different scale according to user's input(choice)

// Add import statement(s) below

import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.String;

public class KhanhConvertTemperature {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double temperature = sc.nextDouble();
        printMenuSource();
        int fromScale = sc.nextInt();
        printMenuDest(fromScale);
        int toScale = sc.nextInt();

        convert(temperature, fromScale, toScale);
    }

    // Print menu to select source scale
    private static void printMenuSource() {
        System.out.println();
        System.out.println("Choose source scale:");
        System.out.println("  1. Celsius");
        System.out.println("  2. Fahrenheit");
        System.out.println("  3. Kelvin");
        System.out.print("Enter your choice: ");
    }

    private static void printMenuDest(int choice) {
        if (choice == 1) {
            System.out.println();
            System.out.println("Choose destination scale:");
            System.out.println("  1. Fahrenheit");
            System.out.println("  2. Kelvin");
            System.out.print("Enter your choice: ");
        }

        if (choice == 2) {
            System.out.println();
            System.out.println("Choose destination scale:");
            System.out.println("  1. Celsius");
            System.out.println("  2. Kelvin");
            System.out.print("Enter your choice: ");
        }
        if (choice == 3) {
            System.out.println();
            System.out.println("Choose destination scale:");
            System.out.println("  1. Celsius");
            System.out.println("  2. Fahrenheit");
            System.out.print("Enter your choice: ");
        }
    }


    // Convert temperature from fromScale to toScale
    private static void convert(double temperature, int fromScale, int toScale) {
        String scale1, scale2;
        double ans = 0;
        if (fromScale == 1 && toScale == 1) {
            scale1 = "Celsius";
            scale2 = "Fahrenheit";
            ans = 1.8 * temperature + 32;
        } else if (fromScale == 1 && toScale == 2) {
            scale1 = "Celsius";
            scale2 = "Kelvin";
            ans = temperature + 273.15;
        } else if (fromScale == 2 && toScale == 1) {
            scale1 = "Fahrenheit";
            scale2 = "Celsius";
            ans = (5.0 / 9) * (temperature - 32);
        } else if (fromScale == 2 && toScale == 2) {
            scale1 = "Fahrenheit";
            scale2 = "Kelvin";
            double c = (5.0 / 9) * (temperature - 32);
            ans = c + 273.15;
        } else if (fromScale == 3 && toScale == 1) {
            scale1 = "Kelvin";
            scale2 = "Celsius";
            ans = temperature - 273.15;
        } else {
            scale1 = "Kelvin";
            scale2 = "Fahrenheit";
            double c = temperature - 273.15;
            ans = 1.8 * c + 32;
        }
        System.out.println();
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.print(temperature + " degrees " + scale1 + " = " + df2.format(ans) + " degrees " + scale2);
    }
}

