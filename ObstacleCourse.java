// CS1020 (AY2014/5 Semester 2)
// Take-home Lab5 Ex2
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will calculate the most efficient way to hop from the first to the last block
// given the input data includes the correct blocks and their corresponding hopping range

import java.util.Scanner;

public class ObstacleCourse {

    public static int loopCount = 0;

	/**
	 * Description:
	 *   ???
	 * Pre-condition(s):
	 *   ???
	 */
	public static int countHops(Block[] blocks, int currIndex) {
        loopCount++;
        int endIndex = blocks.length-1;
        if (currIndex == endIndex) {
            return 0;
        } else {
            for (int i = currIndex+1; i < blocks.length; i++) {
                //System.out.println(hopPossible(blocks, currIndex, i));
                if (!hopPossible(blocks, currIndex, i)) {
                    endIndex = i - 1;
                    break;
                }
            }
            System.out.print("c" + currIndex + ", ");
            System.out.print("e" + endIndex + ", ");
            if (endIndex > currIndex) {
                int[] temp = new int[endIndex - currIndex+1];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = countHops(blocks, currIndex + j+1);
                }
                int min = temp[0];
                for (int k = 1; k < temp.length; k++) {
                    if (temp[k] < min) {
                        min = temp[k];
                    }
                }
                //System.out.println("Min is: " + min);
                return min + 1;
            } else {
                return 5;
            }
        }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Block[] blocks = new Block[n];
		for (int i = 0; i < n; i++) {
			blocks[i] = new Block(sc.nextInt(), sc.nextInt());
		}
		System.out.println(countHops(blocks, 0));
        System.out.println("Loop count is: " + loopCount);
	}

    public static boolean hopPossible(Block[] blocks, int start, int end) {
        boolean result = true;
        for (int i = start+1; i <= end; i++) {
            if (blocks[i].getHeight() > blocks[start].getHoppingRange()) {
                result = false;
                break;
            }
        }
        return result;
    }
}

class Block {

	private int height;
	private int hoppingRange;

	public Block(int height, int hoppingRange) {
		this.height = height;
		this.hoppingRange = hoppingRange;
	}

	public int getHeight() {
		return this.height;
	}

	public int getHoppingRange() {
		return this.hoppingRange;
	}

}

