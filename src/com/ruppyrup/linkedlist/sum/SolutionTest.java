package com.ruppyrup.linkedlist.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }


    @Test
    void canCreateAndPrint() {
        var node = createListNode(2, 4, 3);
        printListNode(node);
    }

    @Test
    void canAddZeroArrays() {
        var node1 = createListNode(0);
        var node2 = createListNode(0);
        var expected = createListNode(0);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void canAddSingleDigitArrays() {
        var node1 = createListNode(3);
        var node2 = createListNode(5);
        var expected = createListNode(8);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void canAddFourDigitArrays() {
        var node1 = createListNode(1, 7, 3, 4);
        var node2 = createListNode(6, 2, 5, 2);
        var expected = createListNode(7, 9, 8, 6);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void canAddTwoDigitOver10Arrays() {
        var node1 = createListNode(6, 4);
        var node2 = createListNode(5, 2);
        var expected = createListNode(1, 7);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void canAddThreeCarryOverArrays() {
        var node1 = createListNode(7, 6, 4);
        var node2 = createListNode(8, 5, 2);
        var expected = createListNode(5, 2, 7);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void carryOneOverWithNewNode() {
        var node1 = createListNode(7, 6, 4);
        var node2 = createListNode(8, 5, 5);
        var expected = createListNode(5, 2, 0, 1);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void unevenArraysWithCarryOver() {
        var node1 = createListNode(9, 9, 9, 9, 9, 9, 9);
        var node2 = createListNode(9, 9, 9, 9);
        var expected = createListNode(8, 9, 9, 9, 0, 0, 0, 1);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    @Test
    void unevenArraysWithSingleInput() {
        var node1 = createListNode(9, 9, 1);
        var node2 = createListNode(1);
        var expected = createListNode(0, 0, 2);
        ListNode result = solution.addTwoNumbers(node1, node2);
        assertLinkNodesEqual(expected, result);
    }

    void assertLinkNodesEqual(ListNode l1, ListNode l2) {
        var current1 = l1;
        var current2 = l2;
        while (current1 != null || current2 != null) {
            Assertions.assertEquals(current1.val, current2.val);
            current1 = current1.next;
            current2 = current2.next;
        }
//        Assertions.assertEquals(current1.val, current2.val);
    }


    ListNode createListNode(int... nums) {
        ListNode result = new ListNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            result = new ListNode(nums[i], result);
        }
        return result;
    }

    void printListNode(ListNode listNode) {
        var current = listNode;
        while (current.next != null) {
            System.out.print(current.val + "-");
            current = current.next;
        }
        System.out.println(current.val);
    }

}
