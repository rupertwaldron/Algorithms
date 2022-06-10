package com.ruppyrup.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSort {

    public int[] sort(int[] unsorted) {
        if (unsorted.length <= 1) return unsorted;

        if (unsorted.length == 2) {
            if (unsorted[0] > unsorted[1]) {
                swap(unsorted, 0, 1);
            }
            return unsorted;
        }

        int pivot = unsorted[0];
        int[] lower = new int[unsorted.length - 1];
        int[] upper = new int[unsorted.length - 1];

        int l = 0, u = 0;

        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i] < pivot) {
                lower[l++] = unsorted[i];
            } else {
                upper[u++] = unsorted[i];
            }
        }

        int[] newLower = new int[l];
        int[] newUpper = new int[u];
        System.arraycopy(lower, 0, newLower, 0, l);
        System.arraycopy(upper, 0, newUpper, 0, u);

        int[] result = new int[unsorted.length];

        int[] sortl = sort(newLower);
        int[] sortu = sort(newUpper);

        System.arraycopy(sortl, 0, result, 0, sortl.length);
        result[sortl.length] = pivot;
        System.arraycopy(sortu, 0, result, sortl.length + 1, sortu.length);

        return result;

    }

    private void swap(int[] array, final int i, final int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}



class TestQuickSort {

    private QuickSort quickSort;

    @BeforeEach
    void setUp() {
        quickSort = new QuickSort();
    }

    @Test
    void testEmpty() {
        int[] input = {};
        assertArrayEquals(input, quickSort.sort(input));
    }

    @Test
    void testOne() {
        int[] input = {3};
        assertArrayEquals(input, quickSort.sort(input));
    }

    @Test
    void testSorted() {
        int[] input = {4, 5, 6, 7, 9};
        assertArrayEquals(input, quickSort.sort(input));
    }

    @Test
    void testUnSorted1() {
        int[] input = {5, 4, 7, 2};
        int[] expected = {2, 4, 5, 7};
        assertArrayEquals(expected, quickSort.sort(input));
    }

    @Test
    void testUnSorted2() {
        int[] input = {8, 5, 9, 2, 4};
        int[] expected = {2, 4, 5, 8, 9};
        assertArrayEquals(expected, quickSort.sort(input));
    }

    @Test
    void sortTimer() {
        int[] input = generateLongArray(100000);
        long start = System.currentTimeMillis();
        quickSort.sort(input);
        System.out.println("Quick sort time = " + (System.currentTimeMillis() - start) + "mSecs");
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
