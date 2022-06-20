package com.ruppyrup.mediums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlidingMedium {

    public double[] medianSlidingWindow(int[] nums, int k) {

        int iterations = nums.length - k + 1;
        double[] medians = new double[iterations];

        List<Integer> sortedList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            sortedList.add(nums[i]);
        }

        Collections.sort(sortedList);

        Node head = new Node(sortedList.get(0));
        Node temp = head;
        for (int i = 1; i < k; i++) {
            Node nextNode = new Node(sortedList.get(i));
            temp.next = nextNode;
            temp = nextNode;
        }

        int previousValue = nums[0];

        for (int i = 0; i < iterations; i++) {
            if (i != 0) {
                head = addNode(head, nums[i + k - 1]);
                head = removeNode(head, previousValue);
                previousValue = nums[i];
            }

            double median;
            if (k % 2 == 0) {
                median = getMedianEven(head, k);
            } else {
                median = getMedianOdd(head, k);
            }
            medians[i] = median;
        }

        return medians;
    }

    double getMedianOdd(Node node, int k) {
        int count = k / 2;
        Node current = node;
        while (count-- > 0) {
            current = current.next;
        }
        return current.value;
    }

    double getMedianEven(Node node, int k) {
        int count = k / 2 - 1;
        Node current = node;
        while (count-- > 0) {
            current = current.next;
        }
        double val1 = current.value;
        double val2 = current.next.value;
        return (val1 + val2)/ 2.0;
    }

    Node addNode(Node node, int value) {
        if (node.value == value || (node.value < value && (node.next == null || node.next.value > value))) {
            return insertNodeAfter(node, value);
        } else if (node.value < value) {
            addNode(node.next, value);
        } else {
            return insertNodeBefore(node, value);
        }
        return node;
    }

    Node removeNode(Node node, int value) {
        if (node.value == value)
            return node.next;
        if (node.next.value == value) {
            node.next = node.next.next;
        } else {
            removeNode(node.next, value);
        }
        return node;
    }

    private Node insertNodeAfter(final Node node, final int value) {
        Node temp = node.next;
        Node newNode = new Node(value);
        node.next = newNode;
        newNode.next = temp;
        return node;
    }

    private Node insertNodeBefore(final Node node, final int value) {
        int temp = node.value;
        Node currentNext = node.next;
        Node next = new Node(temp);
        node.next = next;
        next.next = currentNext;
        node.value = value;
        return node;
    }

}

class Node {
    Node next;

    int value;

    public Node(final int value) {
        this.value = value;
    }
}


class TestSlidingMedium {

    private SlidingMedium sm;

    @BeforeEach
    void setup() {
        sm = new SlidingMedium();
    }

    @Test
    void canFindMedium3Nums() {
        int[] ints = new int[]{1, 3, -1};
        double[] expected = new double[]{1.0};
        double[] result = sm.medianSlidingWindow(ints, 3);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void canFindMedium1Nums() {
        int[] ints = new int[]{1, 2};
        double[] expected = new double[]{1.0, 2.0};
        double[] result = sm.medianSlidingWindow(ints, 1);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void canFindMedium4Nums() {
        int[] ints = new int[]{1, 3, -1, 4};
        double[] expected = new double[]{2.0};
        double[] result = sm.medianSlidingWindow(ints, 4);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void canFindMediumOverArray() {
        int[] ints = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        double[] expected = new double[]{1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
        double[] result = sm.medianSlidingWindow(ints, 3);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void canFindMediumOverArray2() {
        int[] ints = new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2};
        double[] expected = new double[]{2.5, 2.5, 3.0, 2.5, 2.5, 2.5};
        double[] result = sm.medianSlidingWindow(ints, 4);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void canFindMediumOverArray3() {
        int[] ints = new int[]{2147483647, 2147483647};
        double[] expected = new double[]{2147483647.0000};
        double[] result = sm.medianSlidingWindow(ints, 2);
        Assertions.assertArrayEquals(expected, result);
    }
}
