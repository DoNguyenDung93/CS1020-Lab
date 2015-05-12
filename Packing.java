// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex1
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will determine the best way to pack luggage with maximum value and minimum size
// from a pool of items
import java.util.*;

class Item{
	private int value;
	private int size;

	public Item(int size,int value) {
		this.value=value;
		this.size=size;
	}

    public int getValue() {
        return this.value;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        String result = "";
        result = this.getSize() + " " + this.getValue();
        return result;
    }
}

public class Packing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> chosenItem = new ArrayList<Item>();
		int size = sc.nextInt();
        sc.nextLine();
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            items.add(new Item(Integer.valueOf(input[0]), Integer.valueOf(input[1])));
        }

        chosenItem = select(items, chosenItem, size);
        int finalSize = 0;
        int finalValue = 0;
        for (int i = 0; i < chosenItem.size(); i++) {
            finalSize += chosenItem.get(i).getSize();
            finalValue += chosenItem.get(i).getValue();
        }

        System.out.println(finalSize + " " + finalValue);
	}

	//description:
	//precondition:
	//You can change the signature of this method if you want, but you have to use recursion. 
    public static ArrayList<Item> select(ArrayList<Item> remaining,
                                         ArrayList<Item> selected, int remainingSpace) {
        if (remaining.isEmpty()) {
            return selected;
        } else {
            if (remaining.get(remaining.size() - 1).getSize() > remainingSpace) {
                remaining.remove(remaining.size() - 1);
                return select(remaining, selected, remainingSpace);
            } else {
                //ArrayList<Item> tempRemaining = copy(remaining);
                ArrayList<Item> tempSelected = copy(selected);
                Item temp = remaining.remove(remaining.size() - 1);
                ArrayList<Item> tempRemaining = copy(remaining);
                selected.add(temp);
                return compare(select(remaining, selected, remainingSpace - temp.getSize()), select(tempRemaining, tempSelected, remainingSpace));
            }
        }
    }

	//this method makes a copy of an existing Arraylist
	public static ArrayList<Item> copy(ArrayList<Item> arrlist) {
		return new ArrayList<Item>(arrlist);
	}

	// return the arraylist with more value and less size
    public static ArrayList<Item> compare(ArrayList<Item> listOne, ArrayList<Item> listTwo) {
        int valueOne = 0;
        int sizeOne = 0;
        int valueTwo = 0;
        int sizeTwo = 0;
        for (int i = 0; i < listOne.size(); i++) {
            valueOne += listOne.get(i).getValue();
            sizeOne += listOne.get(i).getSize();
        }
        for (int j = 0; j < listTwo.size(); j++) {
            valueTwo += listTwo.get(j).getValue();
            sizeTwo += listTwo.get(j).getSize();
        }
        if (valueOne > valueTwo) {
            return listOne;
        } else if (valueOne == valueTwo) {
            if (sizeOne <= sizeTwo) {
                return listOne;
            } else {
                return listTwo;
            }
        } else {
            return listTwo;
        }
    }
}

