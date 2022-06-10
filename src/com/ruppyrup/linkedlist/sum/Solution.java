package com.ruppyrup.linkedlist.sum;


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

class Solution {

    private int carryOver = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var current1 = l1;
        var current2 = l2;
        ListNode result = addNewNode(l1, l2);
        ListNode currentResult = result;
        while (current1.next != null || current2.next != null) {
            current1 = current1 != null ? current1.next : new ListNode(0);
            current2 = current2 != null ? current2.next : new ListNode(0);
            currentResult.next = addNewNode(current1, current2);
            currentResult = currentResult.next;
            if (current1 == null && current2 != null) {
                current1 = new ListNode(0);
            }
            if (current2 == null && current1 != null) {
                current2 = new ListNode(0);
            }
            if (current1.next == null && current2.next != null) {
                current1.next = new ListNode(0);
            }
            if (current2.next == null && current1.next != null) {
                current2.next = new ListNode(0);
            }
        }
        if (carryOver >= 1) {
            currentResult.next = new ListNode(1);
        }
        return result;
    }

    private ListNode addNewNode(ListNode ln1, ListNode ln2) {
        int ln1Value = ln1 != null ? ln1.val : 0;
        int ln2Value = ln2 != null ? ln2.val : 0;
        int sum = ln1Value + ln2Value + carryOver;
        if (sum >= 10) {
            sum -= 10;
            carryOver = 1;
        } else {
            carryOver = 0;
        }
        return new ListNode(sum);
    }


}
