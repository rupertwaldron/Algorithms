package com.ruppyrup.pairs;

import java.util.Arrays;

public class PairDifference {

    static int pairs1(int k, int[] arr) {
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] - arr[i]) == k) count++;
            }
        }
        return count;
    }


    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if ((arr[i + 1] - arr[i]) > k ) {
                continue;
            }
            else if ((arr[i + 1] - arr[i]) < k) {
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[j] - arr[i]) > k) break;
                    else if ((arr[j] - arr[i]) == k) count++;
                }
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        System.out.println(pairs(k, arr));
        int[] arr1 = {1, 2, 3, 4};
        int k1 = 1;
        System.out.println(pairs(k1, arr1));
    }
}
