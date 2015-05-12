// CS1020 (AY2014/5 Semester 2)
// Take-home Lab2 Ex3
// Name: Do Nguyen Dung
// Matric. No.: A0129889A
// Lab group: C04
// This program will take in a map of the area and determine how many tons of gold
// are available on each grid of the map

import java.util.*;

public class GoldHunter {

    // This method will add gold to each cell of the map that is near a mine cell
    public static int[][] addGoldToMap(MyMap map) {
        int[][] newMap = new int[map.getNumRow() + 2][map.getNumCol() + 2]; // A sentinel array
        for (int i = 0; i < map.getNumRow(); i++) {
            for (int j = 0; j < map.getNumCol(); j++) {
                if (map.getLabel(i, j) == '*') {
                    newMap[i + 1][j + 1] = -1;
                    for (int a = i; a <= i + 2; a++) {
                        for (int b = j; b <= j + 2; b++) {
                            if (newMap[a][b] == -1) {
                                continue;
                            }
                            newMap[a][b]++;
                        }
                    }
                }
            }
        }
        return newMap;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyMap map = new MyMap(sc);

        int[][] newMap = addGoldToMap(map);
        for (int i = 0; i < map.getNumRow(); i++) {
            for (int j = 0; j < map.getNumCol(); j++) {
                map.setGoldVal(i, j, newMap[i + 1][j + 1]);
            }
        }
        map.display();
    }
}

