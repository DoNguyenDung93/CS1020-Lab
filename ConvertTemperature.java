// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex1
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will take in a temperature value and convert it into
// another scale of choice of the user


import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.String;

public class ConvertTemperature {

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

    //Print menu to select destination scale
    private static void printMenuDest(int fromScale) {
        System.out.println();
        System.out.println("Choose destination scale:");
        switch (fromScale) {
            case 1:
                System.out.println("  1. Fahrenheit");
                System.out.println("  2. Kelvin");
                break;
            case 2:
                System.out.println("  1. Celsius");
                System.out.println("  2. Kelvin");
                break;
            default:
                System.out.println("  1. Celsius");
                System.out.println("  2. Fahrenheit");
        }
        System.out.print("Enter your choice: ");
    }

    // Convert temperature from fromScale to toScale
    private static void convert(double temperature, int fromScale, int toScale) {
        double temperatureDest;
        String sourceScale, destScale;
        if (fromScale == 1) {
            sourceScale = "Celsius";
            if (toScale == 1) {
                destScale = "Fahrenheit";
                temperatureDest = 1.8 * temperature + 32;
            } else {
                destScale = "Kelvin";
                temperatureDest = temperature + 273.15;
            }
        } else if (fromScale == 2) {
            sourceScale = "Fahrenheit";
            if (toScale == 1) {
                destScale = "Celsius";
                temperatureDest = (5.0 / 9) * (temperature - 32);
            } else {
                destScale = "Kelvin";
                temperatureDest = (5.0 / 9) * (temperature + 459.67);
            }
        } else {
            sourceScale = "Kelvin";
            if (toScale == 1) {
                destScale = "Celsius";
                temperatureDest = temperature - 273.15;
            } else {
                destScale = "Fahrenheit";
                temperatureDest = 1.8 * temperature - 459.67;
            }
        }
        String pattern = "0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String output = decimalFormat.format(temperatureDest);
        System.out.println();
        System.out.println(temperature + " degrees " + sourceScale + " = " + output + " degrees " + destScale);
    }

}

