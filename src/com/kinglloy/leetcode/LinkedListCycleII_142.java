package com.kinglloy.leetcode;

public class LinkedListCycleII_142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        System.out.println(new LinkedListCycleII_142().detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head.next, second = head.next.next;

        while (first != second && first != null && second != null) {
            first = first.next;
            second = second.next == null ? null : second.next.next;
        }

        boolean hasCycle = first != null && first == second;
        if (!hasCycle) {
            return null;
        }

        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
