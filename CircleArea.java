// This program reads the length of a side of a square and
// computes the area of the circle that encloses the square.

// Add import statement(s) below

import java.util.Scanner;

public class CircleArea {

    // You are to write a circleArea(double r) method to
    // return the area of a circle of radius r.
    public static double circleArea(double r) {
        return Math.pow(r, 2) * Math.PI;
    }

    public static double radius(double side) {
        return Math.sqrt(2 * Math.pow(side, 2)) / 2;
    }

    public static void main(String[] args) {
        // Fill in the code below
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side of square: ");
        double side = sc.nextDouble();
        double radius = radius(side);
        double area = circleArea(radius);

        System.out.printf("Area of circle = %.2f\n", area);

    }
}

