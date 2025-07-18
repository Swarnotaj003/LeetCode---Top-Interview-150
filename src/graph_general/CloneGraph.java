package graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    /*
        LeetCode (91/150)
        https://leetcode.com/problems/clone-graph/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
        Output: [[2,4],[1,3],[2,4],[1,3]]
        Explanation: There are 4 nodes in the graph.
        1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
        3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
        4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

        Example 2:
        Input: adjList = [[]]
        Output: [[]]
        Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
    */

    // original node -> deep copy
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        this.map = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node node) {
        // return if the deep copy already exists
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // create a deep copy
        Node copy = new Node(node.val);
        map.put(node, copy);

        // add neighbors
        List<Node> neighbors = node.neighbors;
        for (Node next : neighbors) {
            copy.neighbors.add(dfs(next));
        }
        return copy;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        node4.neighbors.add(node1);
        node1.neighbors.add(node4);

        Node copy = new CloneGraph().cloneGraph(node1);

        // Print the graph
        Set<Integer> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(copy);
        visited.add(copy.val);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node next : curr.neighbors) {
                System.out.print("[" + curr.val + ", " + next.val + "], ");
                if (!visited.contains(next.val)){
                    visited.add(next.val);
                    q.offer(next);
                }
            }
        }
        System.out.println();
    }
}
