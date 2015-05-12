// CS1020 (AY2014/5 Semester 2)
// Take-home Lab1 Ex3
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will calculate the area of the overlapping area
// between two rectangles

import java.util.Scanner;
import java.awt.geom.Point2D;
import java.awt.Point;

public class OverlapRectangles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
        Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
        Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());

        System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
        Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
        Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());

        // For testing. Remove or comment off the statement below after testing.
        // printAllVertices(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);

        arrangeVertices(rect1Vertex1, rect1Vertex2);
        arrangeVertices(rect2Vertex1, rect2Vertex2);
        // printAllVertices(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);

        int area = (int) overlapArea(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);

        System.out.println("Overlap area = " + Math.max(0, area));
    }

    // This method is provided for your testing.
    // To print the 2 opposite vertices of each of the 2 rectangles.
    /*public static void printAllVertices(Point r1V1, Point r1V2,
                                        Point r2V1, Point r2V2) {
		System.out.println("1st rectangle vertex 1: " + r1V1);
		System.out.println("1st rectangle vertex 2: " + r1V2);
		System.out.println("2nd rectangle vertex 1: " + r2V1);
		System.out.println("2nd rectangle vertex 2: " + r2V2);
	}*/

    // This method will rearrange the vertices of the rectangles
    public static void arrangeVertices(Point r1V1, Point r1V2) {
        double x1, y1, x2, y2; // The coordinates of the 2 points
        x1 = r1V1.getX();
        y1 = r1V1.getY();
        x2 = r1V2.getX();
        y2 = r1V2.getY();
        r1V1.setLocation(Math.min(x1, x2), Math.min(y1, y2));
        r1V2.setLocation(Math.max(x1, x2), Math.max(y1, y2));
    }

    // This method will calculate the area of the overlapping area
    public static double overlapArea(Point r1V1, Point r1V2,
                                     Point r2V1, Point r2V2) {
        double xSide = Math.max(0, (Math.min(r1V2.getX(), r2V2.getX()) - Math.max(r1V1.getX(), r2V1.getX())));
        double ySide = Math.max(0, (Math.min(r1V2.getY(), r2V2.getY()) - Math.max(r1V1.getY(), r2V1.getY())));
        xSide = Math.abs(xSide);
        ySide = Math.abs(ySide);

        return xSide * ySide;
    }

}

