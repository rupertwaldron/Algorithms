package com.ruppyrup.pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductPairs {

    static int[] solve(int[] nums, int match) {
        if (nums.length <= 1) return new int[]{};
        if (nums.length == 2) return nums;

        int nearest = Integer.MAX_VALUE;
        int[] result = new int[2];

        int l = 0;
        int r = nums.length - 1;
        while (l != r) {
            int product = nums[l] * nums[r];

            if ((product - match) < nearest) {
                nearest = product - match;
            }

            result[0] = nums[l];
            result[1] = nums[r];

            if (product > match) {
                r--;
            } else if (product < match)  {
                l++;
            } else {
                break;
            }
        }

        return result;
    }

}




class ProductPairTest {

    @Test
    void checkEmpty() {
        int[] input = new int[]{};
        Assertions.assertArrayEquals(input, ProductPairs.solve(input, 7));
    }

    @Test
    void checkTwoNumbers() {
        int[] input = new int[]{3, 7};
        Assertions.assertArrayEquals(input, ProductPairs.solve(input, 7));
    }

    @Test
    void checkThreeNumbers() {
        int[] input = new int[]{3, 5, 7};
        int[] expected = new int[]{3, 5};
        Assertions.assertArrayEquals(expected, ProductPairs.solve(input, 15));
    }

    @Test
    void checkThreeNumbersNearest() {
        int[] input = new int[]{3, 5, 7};
        int[] expected = new int[]{3, 5};
        Assertions.assertArrayEquals(expected, ProductPairs.solve(input, 14));
    }

    @Test
    void checkThreeNumbersNearest2() {
        int[] input = new int[]{3, 5, 7, 9, 10, 30, 39, 50};
        int[] expected = new int[]{9, 10};
        Assertions.assertArrayEquals(expected, ProductPairs.solve(input, 78));
    }

}
