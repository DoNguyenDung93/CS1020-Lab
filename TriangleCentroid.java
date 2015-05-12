// This program reads integer coordinates of 3 points and creates
// 3 Point objects. It then computes the centroid of a triangle
// having these 3 points as its vertices.

// Add the import statement(s) below

import java.awt.Point;
import java.awt.geom.*;
import java.util.Scanner;

public class TriangleCentroid {

    // Returns the centroid of a triangle with
    // 3 vertices v1, v2 and v3
    public static Point2D.Double centroid(Point v1, Point v2, Point v3) {
        double x = (v1.getX() + v2.getX() + v3.getX()) / 3;
        double y = (v1.getY() + v2.getY() + v3.getY()) / 3;
        Point2D.Double centroid = new Point2D.Double(x, y);
        return centroid;
    }

    public static void main(String[] args) {
        // Fill in the code
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 3 vertices: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        Point v1 = new Point(x1, y1);
        Point v2 = new Point(x2, y2);
        Point v3 = new Point(x3, y3);

        Point2D.Double centroid = centroid(v1, v2, v3);
        System.out.println("Centroid at " + centroid.toString());
    }
}

