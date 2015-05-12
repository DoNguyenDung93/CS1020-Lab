// Testing the Scanner class.
// This program reads the name, age and vaccination status of
// some children and computes their average age and percentage
// of children who are vaccinated.
// Unlike the earlier version (practice exercise 4), this version
// keeps reading in data until there is no more name.

// Add import statement(s) below

import java.util.Scanner;

public class Vaccination_V2 {
    public static int MAX_CHILDREN = 100;

    public static void main(String[] args) {
        String[] name = new String[MAX_CHILDREN];
        int age, totalAge = 0;
        int numVaccinated = 0;

        Scanner sc = new Scanner(System.in);
        int i = 0;
        int numChildren = 0;
        System.out.print("Name: ");
        do {

            name[i] = sc.nextLine();
            System.out.println("Name is \"" + name[i] + "\"");
            System.out.print("Age: ");
            age = sc.nextInt();
            totalAge += age;
            System.out.println("Age is " + age);
            System.out.print("Vaccinated for chickenpox? ");
            boolean vaccinated = sc.nextBoolean();
            sc.nextLine();
            if (vaccinated) {
                numVaccinated++;
                System.out.println("Vaccinated for chickenpox");
            } else {
                System.out.println("Not vaccinated for chickenpox");
            }
            i++;
            numChildren++;
            System.out.print("Name: ");
        } while (sc.hasNextLine());
        double averageAge = ((double) totalAge) / numChildren;
        System.out.printf("Average age is %.2f\n", averageAge);
        double percentVaccinated = (((double) numVaccinated) / numChildren) * 100;
        System.out.printf("Percentage of children vaccinated is %.2f%%\n", percentVaccinated);

    }
}
