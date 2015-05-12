// CS1020 (AY2014/5 Semester 2)
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will convert a date in the UK format into US format.
// It will also report whether the year is a leap year or not.

import java.lang.String;
import java.util.*;

public class DateConvert {

    // This method will check whether a year is a leap year or not
    public static boolean isLeapYear(int year) {
        if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0))) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date in UK format: ");
        String month = sc.next();
        String dateStr = sc.next();
        dateStr = dateStr.replaceAll(",", " ");
        String yearStr = sc.next();
        int year = Integer.valueOf(yearStr);

        System.out.println("Date in American format: " + dateStr + month + " " + yearStr);
        if (isLeapYear(year) == true) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

    }
}

