package com.ruppyrup.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list2 == null) return list1;

        if (list1.val < list2.val && list1.next.val < list2.val) {
            mergeTwoLists(list1.next, list2);
        } else if (list2.val < list1.val && list2.next.val < list1.val) {
            mergeTwoLists(list1, list2.next);
        } else if (list1.val <= list2.val) {
            insertNodeAfter(list1, list2);
            if (list2.next == null) return list1;
            mergeTwoLists(list1.next, list2.next);

        } else {
            insertNodeBefore(list2, list1);
            mergeTwoLists(list1.next, list2.next);
        }

        return list1;
    }

    private void insertNodeAfter(ListNode node1, ListNode node2) {
        ListNode temp = node1.next;
        node1.next = new ListNode(node2.val, temp);
    }

    private void insertNodeBefore(ListNode node1, ListNode node2) {
        node1.val = node2.val;
        node1.next = node1;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class mslTest {

    private MergeSortedLists msl;

    @BeforeEach
    void setUp() {
        msl = new MergeSortedLists();
    }

    @Test
    void testTwoEmptyLists() {
        ListNode input1 = new ListNode();
        ListNode input2 = new ListNode();
        ListNode listNode = msl.mergeTwoLists(input1, input2);
        printListNode(listNode);
        assertLinkNodesEqual(input1, input2);
    }

    @Test
    void testTwoLists() {
        ListNode input1 = createListNode(1, 2, 4);
        ListNode input2 = createListNode(1, 3, 4);
        ListNode listNode = msl.mergeTwoLists(input1, input2);
        printListNode(listNode);
        ListNode expected = createListNode(1, 1, 2, 3, 4, 4);
        assertLinkNodesEqual(expected, listNode);
    }

    void assertLinkNodesEqual(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return;
        var current1 = l1;
        var current2 = l2;
        while (current1.next != null || current2.next != null) {
            Assertions.assertEquals(current1.val, current2.val);
            if (current1.next == null || current2.next == null) break;
            current1 = current1.next;
            current2 = current2.next;
        }
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
