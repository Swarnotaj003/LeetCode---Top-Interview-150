package binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Implementation of a node in binary tree
 * alongwith some helper methods
 * To be used in related DSA problems
 */

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // convert binary tree into string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        levelOrder(this, sb);
        return sb.toString();
    }

    private void levelOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                sb.append(current.val).append(" ");
                queue.add(current.left);
                queue.add(current.right);
            } else {
                sb.append("N ");
            }
        }
    }

    // convert input string into binary tree
    public static TreeNode createBinaryTree(String[] input) {
        if (input.length == 0 || input[0].equalsIgnoreCase("N") || input[0].equalsIgnoreCase("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < input.length && !input[i].equalsIgnoreCase("N") && !input[i].equalsIgnoreCase("null")) {
                current.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < input.length && !input[i].equalsIgnoreCase("N") && !input[i].equalsIgnoreCase("null")) {
                current.right = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = search(root.left, val);
        TreeNode right = search(root.right, val);
        return left == null ? right : left;
    }
}
