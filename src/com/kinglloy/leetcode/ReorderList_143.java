package com.kinglloy.leetcode;

public class ReorderList_143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        new ReorderList_143().reorderList(head);
        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int size = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            size++;
        }

        ListNode r = head;
        int middle = size / 2 + size % 2;
        for (int i = 0; i < middle - 1; i++) {
            r = r.next;
        }
        p = r;
        r = r.next;
        p.next = null;

        ListNode i = r;
        ListNode k = r;
        ListNode j = r.next;
        while (j != null) {
            k.next = j.next;
            j.next = i;
            i = j;
            j = k.next;
        }

        r = i;
        ListNode l = head.next;
        ListNode l1 = l == null ? null : l.next;
        ListNode r1 = r.next;

        p = head;
        while (l != null || r != null) {
            if (r != null) {
                p.next = r;
                r = r1;
                r1 = r1 == null ? null : r1.next;
                p = p.next;
            }
            if (l != null) {
                p.next = l;
                l = l1;
                l1 = l1 == null ? null : l1.next;
                p = p.next;
            }
        }
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
