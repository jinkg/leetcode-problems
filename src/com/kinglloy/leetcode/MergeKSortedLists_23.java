package com.kinglloy.leetcode;

import java.util.Arrays;

public class MergeKSortedLists_23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        (node1.next = new ListNode(4)).next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        (node2.next = new ListNode(3)).next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode result = mergeKLists(new ListNode[]{node1, node2, node3});
        System.out.println(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ans = merge2Lists(ans, lists[i]);
        }
        return ans;
    }

    private static ListNode merge2Lists(ListNode A, ListNode B) {
        ListNode C = new ListNode(0);
        ListNode a = A, b = B, c = C;
        while (a != null && b != null) {
            if (a.val < b.val) {
                c.next = new ListNode(a.val);
                a = a.next;
            } else {
                c.next = new ListNode(b.val);
                b = b.next;
            }
            c = c.next;
        }
        while (a != null) {
            c.next = new ListNode(a.val);
            a = a.next;
            c = c.next;
        }
        while (b != null) {
            c.next = new ListNode(b.val);
            b = b.next;
            c = c.next;
        }
        return C.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
