package com.ruppyrup.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSort {

    public int[] sort(int[] unsorted) {
        if (unsorted.length <= 1) return unsorted;

        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - i - 1; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    swap(unsorted, j);
                }
            }
        }
        return unsorted;
    }

    private void swap(int[] array, final int j) {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

}



class TestSort {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void testEmpty() {
        int[] input = {};
        assertArrayEquals(input, bubbleSort.sort(input));
    }

    @Test
    void testOne() {
        int[] input = {3};
        assertArrayEquals(input, bubbleSort.sort(input));
    }

    @Test
    void testSorted() {
        int[] input = {4, 5, 6, 7, 9};
        assertArrayEquals(input, bubbleSort.sort(input));
    }

    @Test
    void testUnSorted() {
        int[] input = {8, 5, 9, 2, 4};
        int[] expected = {2, 4, 5, 8, 9};
        assertArrayEquals(expected, bubbleSort.sort(input));
    }

    @Test
    void sortTimer() {
        int[] input = generateLongArray(100000);
        long start = System.currentTimeMillis();
        bubbleSort.sort(input);
        System.out.println("Selection sort time = " + (System.currentTimeMillis() - start) + "mSecs");
    }

    private static int[] generateLongArray(int n) {
        Random random = new Random();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = random.nextInt();
        }
        return result;
    }

}
