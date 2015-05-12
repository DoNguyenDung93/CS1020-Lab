// CS1020 (AY2014/5 Semester 2)
// Take-home Lab4 Ex1
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will receive a series of cargoes ready to be shipped and it will calculate
// the minimum number of stacks of cargoes for the most efficient shipping. Ships will arrive in
// alphabetical order.

import java.util.*;

public class CargoOptimization {

    private ArrayList<Stack<Container>> stacks; // use an array list to represent the stacks in the terminal

    //private static Container[] listOfCargoes;
    public CargoOptimization() {
        stacks = new ArrayList<Stack<Container>>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CargoOptimization optimizer = new CargoOptimization();
        String input = sc.nextLine();
        //listOfCargoes = new Container[input.length()];
        for (int i = 0; i < input.length(); i++) {
            int number = 0; // number of a type of cargo
            //listOfCargoes[i] = new Container(input.charAt(i));
            optimizer.processContainer(input.charAt(i));
        }
        System.out.println(optimizer.getNumOfStacks());
        //System.out.println(optimizer);
    }

    public int getNumOfStacks() {
        return stacks.size();
    }

    // handles each arriving container
    public void processContainer(char ship) {
        Container arriving = new Container(ship);
        int compability;
        int minCompability = 26;
        if (stacks.size() == 0) {
            stacks.add(new Stack<Container>());
            stacks.get(0).push(arriving);
        } else {
            for (int i = 0; i < stacks.size(); i++) {
                compability = arriving.calculateFitWith(stacks.get(i));
                minCompability = Math.min(compability, minCompability);
                if (compability <= 0) {
                    stacks.get(i).push(arriving);
                    break;
                }
                    /*int oldNumber = stacks.size();
                    stacks.add(new Stack<Container>());
                    stacks.get(oldNumber).push(arriving);*/
            }
            if (minCompability > 0) {
                int oldNumber = stacks.size();
                stacks.add(new Stack<Container>());
                stacks.get(oldNumber).push(arriving);
            }
        }
    }

    // returns the index of the best stack to put the container in
    /*private int findBestStack(Container newArrival) {

		return -1; // complete the method
		
	}
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < stacks.size(); i++) {
            result = result + stacks.get(i).peek() + ";";
        }
        return result;
    }*/
}


class Container {
    private char destination;

    public Container(char destination) {
        this.destination = destination;
    }

    /*public char getDestination() {
        return this.destination;
    }*/

    // method should return compatibility score between this container and the target stack.
    // they are most compatible when the container at the top of the stack has the same destination as this container
    public int calculateFitWith(Stack<Container> candidate) {
        String destinationOne = this.destination + "";
        String destinationTwo = candidate.peek().destination + "";
        //System.out.println(destinationOne.compareTo(destinationTwo));
        return destinationOne.compareTo(destinationTwo);
    }

    /*
    @Override
    public String toString() {
        String result = this.destination + "";
        return result;
    } */
}
