package com.ruppyrup.knapsack;

import java.util.Arrays;


public class Thief {


    private static int calculateWhatToSteal(int[] values, int[] sizes, int bagSize) {

        int itemCount = values.length;


        int[][] table = new int[itemCount][bagSize];

        for (int i = 0; i < itemCount; i++) {
            for (int j = 0; j < bagSize; j++) {
                if (i == 0) {
                    table[i][j] = values[i];
                    continue;
                }

                int previousValue = table[i - 1][j];

                if (sizes[i] <= i) {
                    int valueOfRemainingSpace = (j - sizes[j] < 0)  ? 0 : table[i - 1][j - sizes[j]];
                    table[i][j] = Math.max(previousValue, values[i] + valueOfRemainingSpace);
                } else {
                    table[i][j] = previousValue;
                }


            }
        }

        return table[itemCount - 1][bagSize - 1];
    }


    public static void main(String[] args) {
        int[] values = {1500, 2000, 3000};
        int[] sizes = {1, 3, 4};
        int bagSize = 4;

        System.out.println(calculateWhatToSteal(values, sizes, bagSize));

    }
}
