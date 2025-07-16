package binary_tree_general;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulateNextRightPointersII {
    /*
        LeetCode (74/150)
        https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [1,2,3,4,5,null,7]
        Output: [1,#,2,3,#,4,5,7,#]
        Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
        
        Example 2:
        Input: root = []
        Output: []        
    */

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        // level order predecessor
        Node prev = null;
        int depth = getDepth(root);
 
        while (depth > 0) {
            Node curr = q.poll();

            // end of level reached
            if (curr == null) {
                depth--;
                prev = null;
                q.offer(null);
                continue;
            }

            // add children if not null
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }

            // connect to level order successor
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
        }
        return root;
    }

    private int getDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // create the tree
        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            Node current = queue.poll();

            // Left child
            if (i < input.length && !input[i].equalsIgnoreCase("N") && !input[i].equalsIgnoreCase("null")) {
                current.left = new Node(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < input.length && !input[i].equalsIgnoreCase("N") && !input[i].equalsIgnoreCase("null")) {
                current.right = new Node(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }

        Node ans = new PopulateNextRightPointersII().connect(root);

        // print level order using next pointer
        Set<Node> visited = new HashSet<>();
        queue.clear();
        queue.offer(ans);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (visited.contains(curr)) {
                continue;
            }

            visited.add(curr);
            System.out.print(curr.val + " ");
            if (curr.next == null) {
                System.out.print("# ");
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        System.out.println();
    }
}
