package com.ruppyrup.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSort {

    public int[] sort(int[] unsorted) {
        if (unsorted.length <= 1) return unsorted;

        for (int i = 0; i < unsorted.length - 1; i++) {
            int min = unsorted[i];
            int swapPoint = i;
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[j] < min) {
                    min = unsorted[j];
                    swapPoint = j;
                }
            }
            swap(unsorted, i, swapPoint);
        }
        return unsorted;
    }

    private void swap(int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}



class TestSelectionSort {

    private SelectionSort selectionSort;

    @BeforeEach
    void setUp() {
        selectionSort = new SelectionSort();
    }

    @Test
    void testEmpty() {
        int[] input = {};
        assertArrayEquals(input, selectionSort.sort(input));
    }

    @Test
    void testOne() {
        int[] input = {3};
        assertArrayEquals(input, selectionSort.sort(input));
    }

    @Test
    void testSorted() {
        int[] input = {4, 5, 6, 7, 9};
        assertArrayEquals(input, selectionSort.sort(input));
    }

    @Test
    void testUnSorted1() {
        int[] input = {5, 4, 7, 2};
        int[] expected = {2, 4, 5, 7};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    void testUnSorted2() {
        int[] input = {8, 5, 9, 2, 4};
        int[] expected = {2, 4, 5, 8, 9};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    void sortTimer() {
        int[] input = generateLongArray(100000);
        long start = System.currentTimeMillis();
        selectionSort.sort(input);
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
