// This program reads data in different formats and performs
// the respective operations.

import java.util.Scanner;

public class Reading {

    // Add a method operate(String, int, int) below
    public static int operate(String operation, int num1, int num2) {
        int result = 0;
        if (operation.contains("ADD")) {
            result = num1 + num2;
        } else if (operation.contains("SUB")) {
            result = num1 - num2;
        } else if (operation.contains("MUL")) {
            result = num1 * num2;
        } else {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String format = sc.nextLine();
        if (format.contains("LIMIT")) {
            int numOfOperation = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < numOfOperation; i++) {
                System.out.println(operate(sc.next(), sc.nextInt(), sc.nextInt()));
                sc.nextLine();
            }
        } else if (format.contains("SENTINEL")) {
            while (!sc.hasNext("-1")) {
                System.out.println(operate(sc.next(), sc.nextInt(), sc.nextInt()));
                sc.nextLine();
            }
        } else if (format.contains("EOF")) {
            while (sc.hasNextLine()) {
                System.out.println(operate(sc.next(), sc.nextInt(), sc.nextInt()));
                sc.nextLine();
            }
        } else {
            System.out.println("Wrong input.");
        }
    }
}
