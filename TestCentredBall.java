// To test out CentredBall class 

// Add import statement(s) below

import java.util.Scanner;
import java.awt.*;

public class TestCentredBall {

    // This method reads ball's input data from user, creates
    // a ball object, and returns it to the caller.
    public static CentredBall readBall(Scanner sc) {

        System.out.print("Enter colour, radius and centre: ");
        String inputColour = sc.next();
        double inputRadius = sc.nextDouble();
        int inputX = sc.nextInt();
        int inputY = sc.nextInt();
        Point centre = new Point(inputX, inputY);
        return new CentredBall(inputColour, inputRadius, inputX, inputY);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CentredBall b;
        // Read input and create 1st ball object
        System.out.println("1st ball");
        CentredBall b1 = readBall(scanner);

        // Read input and create 2nd ball object
        System.out.println("2nd ball");
        CentredBall b2 = readBall(scanner);

        // Read input and create 3rd ball object
        System.out.println("3rd ball");
        CentredBall b3 = readBall(scanner);
        System.out.println();

        if (b1.equals(b2)) {
            System.out.println("1st and 2nd balls are the same.");
        } else {
            System.out.println("1st and 2nd balls are not the same.");
        }
        if (b1.getRadius() >= b2.getRadius()) {
            if (b1.getRadius() >= b3.getRadius()) {
                b = b1;
            } else {
                b = b3;
            }
        } else {
            if (b2.getRadius() >= b3.getRadius()) {
                b = b2;
            } else {
                b = b3;
            }
        }
        System.out.println("The largest ball created is:");
        System.out.println(b);

    }
}

