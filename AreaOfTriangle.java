// CS1020 (AY2014/5 Semester 2)
// Name: Do Nguyen Dung
// Matric. No.: A0129889
// Lab group: C04
// This program will calculate the area of a triangle using the length of its 3 sides

import java.util.*;

public class AreaOfTriangle {

    // This method will calculate the area of a triangle given its 3 sides
    public static double area(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
    }

    public static void main(String[] args) {
        double side1, side2, side3;  // lengths of sides of triangle
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 3 lengths: ");
        side1 = sc.nextDouble();
        side2 = sc.nextDouble();
        side3 = sc.nextDouble();

        if (((side1 + side2) <= side3) || ((side1 + side3) <= side2) || ((side2 + side3) <= side1)) {
            System.out.println("Invalid triangle!");
        } else {
            System.out.printf("Area = %.2f\n", area(side1, side2, side3));
        }


    }
}


