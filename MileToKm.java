// Converts distance in miles to kilometres.
// Add import statement below

import java.util.*;

public class MileToKm {
    // Add constant below.
    // Java naming convention:
    // Constant names should be in uppercase, with words
    // separated by underscores.

    public static final double KM_PER_MILE = 1.609;

    public static double convert(double miles) {
        double km;
        return km = miles * KM_PER_MILE;
    }

    public static void main(String[] args) {
        // Fill in the code for the main() method
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in miles: ");
        double miles = sc.nextDouble();
        System.out.printf("That equals %9.2f km.\n", convert(miles));

    }
}

