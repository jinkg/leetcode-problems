package com.kinglloy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node n = head;

        while (n != null) {
            map.put(n, new Node(n.val, null, null));
            n = n.next;
        }

        n = head;
        while (n != null) {
            if (n.next != null) {
                map.get(n).next = map.get(n.next);
            }
            if (n.random != null) {
                map.get(n).random = map.get(n.random);
            }
            n = n.next;
        }
        return map.get(head);
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}
