// Testing the Scanner class.
// This program reads the name, age and vaccination status of
// some children and computes their average age and percentage
// of children who are vaccinated.

// Add import statement(s) below

import java.util.*;


public class Vaccination {
    public static int MAX_CHILDREN = 100;

    public static void main(String[] args) {
        String[] name = new String[MAX_CHILDREN];
        int age, totalAge = 0;
        int numVaccinated = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Number of children: ");
        int numChildren = sc.nextInt();
        sc.nextLine();
        System.out.println("Number of children is " + numChildren);
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Name: ");
            name[i] = sc.nextLine();
            System.out.println("Name is \"" + name[i] + "\"");
            System.out.print("Age: ");
            age = sc.nextInt();
            totalAge += age;
            System.out.println("Age is " + age);
            System.out.print("Vaccinated for chickenpox? ");
            boolean vaccinated = sc.nextBoolean();
            sc.nextLine();
            if (vaccinated == true) {
                numVaccinated++;
                System.out.println("Vaccinated for chickenpox");
            } else {
                System.out.println("Not vaccinated for chickenpox");
            }
        }
        double averageAge = ((double) totalAge) / numChildren;
        System.out.printf("Average age is %.2f\n", averageAge);
        double percentVaccinated = (((double) numVaccinated) / numChildren) * 100;
        System.out.printf("Percentage of children vaccinated is %.2f%%\n", percentVaccinated);

    }
}

