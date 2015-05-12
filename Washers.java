// Compute total weight of a batch of washers
// Add import statement below

import java.util.*;

// What should be the name of the class?
public class Washers {

    // Compute area of a circle
    // Fill in the method circleArea() below
    public static double circleArea(double diameter) {
        double area = Math.PI * Math.pow(diameter / 2, 2);
        return area;
    }

    public static void main(String[] args) {
        // Fill in the code for the main() method
        Scanner sc = new Scanner(System.in);

        System.out.print("Inner diameter in cm: ");
        double innerD = sc.nextDouble();
        System.out.print("Outer diameter in cm: ");
        double outerD = sc.nextDouble();
        System.out.print("Thickness in cm: ");
        double thick = sc.nextDouble();
        System.out.print("Density in grams per cubic cm: ");
        double density = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        //compute weight of a single washer
        double rimArea = circleArea(outerD) - circleArea(innerD);
        double unitWeight = rimArea * thick * density;

        //compute weight of a batch of washers
        double totalWeight = unitWeight * qty;

        System.out.printf("Total weight of %d washers is %.2f grams.\n", qty, totalWeight);
    }
}

