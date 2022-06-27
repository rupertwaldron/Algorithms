package com.ruppyrup.subarrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;


// Dynamic programming tricky
public class LargestSubArray {


    public int maxSubArray(int[] nums) {
        if (nums.length <= 1) return nums[0];


        int countNeg = 0;
        int countPos = 0;
        int leastNeg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                countNeg++;
                if (nums[i] > leastNeg) {
                    leastNeg = nums[i];
                }
            }
            else {
                countPos++;
            }
        }
        int maxSum = sum(nums);

        if (countNeg == nums.length) return leastNeg;
        if (countPos == nums.length) return maxSum;

        int l = 0;
        int r = nums.length - 1;


        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (l < rightIndex) {

            int[] newSum = Arrays.copyOfRange(nums, ++l, r + 1);
            int sum = sum(newSum);
            if (sum > maxSum) {
                leftIndex = l;
                maxSum = sum;
            }

        }

        while (leftIndex < r) {

            int[] newSum = Arrays.copyOfRange(nums, leftIndex, --r + 1);
            int sum = sum(newSum);
            if (sum > maxSum) {
                rightIndex = r;
                maxSum = sum;
            }

        }


        return sum(Arrays.copyOfRange(nums, leftIndex, rightIndex + 1));
    }


    private int sum(int[] input) {
        return Arrays.stream(input)
                .reduce(0, Integer::sum);
    }
}

class LargestSubArrayTest {


    private LargestSubArray lsa;

    @BeforeEach
    void setUp() {
        lsa = new LargestSubArray();
    }

    @Test
    void testOne() {
        int[] input = new int[]{1};
        Assertions.assertEquals(1, lsa.maxSubArray(input));
    }

    @Test
    void testLong() {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] expected = new int[]{4, -1, 2, 1};
        Assertions.assertEquals(6, lsa.maxSubArray(input));
    }

    @Test
    void testLong2() {
        int[] input = new int[]{5,4,-1,7,8};
        int[] expected = new int[]{5, 4, -1, 7, 8};
        Assertions.assertEquals(23, lsa.maxSubArray(input));
    }

    @Test
    void testLong3() {
        int[] input = new int[]{-1, -2};
        int[] expected = new int[]{5, 4, -1, 7, 8};
        Assertions.assertEquals(-1, lsa.maxSubArray(input));
    }

    @Test
    void testLong4() {
        int[] input = new int[]{1, 2, 3};
        Assertions.assertEquals(6, lsa.maxSubArray(input));
    }

    @Test
    void testLong5() {
        int[] input = new int[]{0, -2, -3};
        Assertions.assertEquals(0, lsa.maxSubArray(input));
    }
}
