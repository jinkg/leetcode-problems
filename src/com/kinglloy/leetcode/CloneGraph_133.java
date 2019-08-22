package com.kinglloy.leetcode;

import java.util.*;

public class CloneGraph_133 {
    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        Node ans = new CloneGraph_133().cloneGraph(node1);
        System.out.println(ans);
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();

        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);

        while (!Q.isEmpty()) {
            Node n = Q.poll();
            if (!visited.containsKey(n)) {
                visited.put(n, new Node(n.val, new ArrayList<>()));

                for (Node neighbor : n.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        Q.offer(neighbor);
                    } else {
                        int index = n.neighbors.indexOf(neighbor);
                        if (visited.get(n).neighbors.size() > index) {
                            visited.get(n).neighbors.add(index, visited.get(neighbor));
                        } else {
                            visited.get(n).neighbors.add(visited.get(neighbor));
                        }

                        index = neighbor.neighbors.indexOf(n);
                        if (visited.get(neighbor).neighbors.size() > index) {
                            visited.get(neighbor).neighbors.add(index, visited.get(n));
                        } else {
                            visited.get(neighbor).neighbors.add(visited.get(n));
                        }
                    }
                }
            }
        }
        return visited.get(node);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    ;
}
