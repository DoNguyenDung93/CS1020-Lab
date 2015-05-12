/*  
 * CS1020 (AY2012/3 Sem2)  
 * Sit-in Lab #3 Morning session
 * Author    :   
 * Matric no.:   
 * Lab group : 
 * Description of program:   
 */

import java.util.*;


/* WebBrowser Simulator */
public class WebBrowser {

    private LinkedList<String> firstPart; // the first part of the history, up to the current page
    private LinkedList<String> copyOfFirstPart;
    private LinkedList<String> secondPart; // the second part of the history, after the current page

    public WebBrowser() {
        firstPart = new LinkedList<String>();
        secondPart = new LinkedList<String>();
        copyOfFirstPart = new LinkedList<String>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WebBrowser bc = new WebBrowser();
        boolean result = true;
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            if (temp.equals("BACKWARD")) {
                if (bc.isEmpty()) {
                    result = false;
                    continue;
                }
                bc.backward();
                result = true;
            } else if (temp.equals("FORWARD")) {
                if (bc.isEmpty()) {
                    result = false;
                    continue;
                }
                bc.forward();
                result = true;
            } else {
                bc.addURL(temp);
                bc.clearForward();
            }
        }
        //System.out.println(result);
        if (result) {
            System.out.println("Browsing History:");
            bc.printList();
            System.out.println("Current Page:");
            bc.printCurrent();
        } else {
            System.out.println("Browsing history is empty.");
        }
    }

    // this method will move an URL from firstPart to secondPart
    public void backward() {
        if (firstPart.size() >= 2) {
            String name = firstPart.removeLast();
            copyOfFirstPart.removeLast();
            secondPart.addFirst(name);
            //System.out.println(firstPart.isEmpty());
            //System.out.println(secondPart.isEmpty());
            //System.out.println();
        }
    }

    // this method will move an URL from secondPart to firstPart
    public void forward() {
        if (secondPart.size() >= 1) {
            String name = secondPart.removeFirst();
            firstPart.addLast(name);
            copyOfFirstPart.addLast(name);
            //System.out.println(firstPart.isEmpty());
            //System.out.println(secondPart.isEmpty());
            //System.out.println();
        }
    }

    // this method will add an URL to the firstPart
    public void addURL(String name) {
        firstPart.addLast(name);
        copyOfFirstPart.addLast(name);
    }

    // this method will clear the secondPart
    public void clearForward() {
        while (!secondPart.isEmpty()) {
            secondPart.removeLast();
        }
    }

    // this method will print out the 2 parts
    public void printList() {
        while (!firstPart.isEmpty()) {
            System.out.println(firstPart.removeFirst());
        }
        while (!secondPart.isEmpty()) {
            System.out.println(secondPart.removeFirst());
        }
    }

    // this method will print out the current page
    public void printCurrent() {
        System.out.println(copyOfFirstPart.getLast());
    }

    // this method will check whether if the history is empty
    public boolean isEmpty() {
        return firstPart.isEmpty() && secondPart.isEmpty();
    }
}
