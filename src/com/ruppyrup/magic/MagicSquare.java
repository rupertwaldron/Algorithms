package com.ruppyrup.magic;

import java.util.HashMap;
import java.util.Map;

public class MagicSquare {

    public static void main(String[] args) {

        int[][] mixed = {{4, 8, 2},
                         {4, 5, 7},
                         {6, 1, 6}};

        int[][] magic = {{8, 3, 4},
                         {1, 5, 9},
                         {6, 7, 2}};

        System.out.println(containsUnique(mixed));
        System.out.println(containsUnique(magic));

    }

    static boolean containsUnique(int[][] arr) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = arr[i][j];
                if (!nums.containsKey(val)) {
                    nums.put(val, 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
