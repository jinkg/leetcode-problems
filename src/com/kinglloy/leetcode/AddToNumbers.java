package com.kinglloy.leetcode;

/**
 * 2.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddToNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode currentResult = new ListNode(0);
        currentResult.next = result;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val)
                    + carry;

            carry = sum / 10;

            if (currentResult.next == null) {
                currentResult.next = new ListNode(0);
            }
            currentResult = currentResult.next;
            currentResult.val = sum % 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);

        ListNode result = new AddToNumbers().addTwoNumbers(l1, l2);

        for (ListNode r = result; r != null; r = r.next) {
            System.out.println(r.val);
        }
    }
}
