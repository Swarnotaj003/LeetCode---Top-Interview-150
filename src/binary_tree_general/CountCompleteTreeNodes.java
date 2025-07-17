package binary_tree_general;

import java.util.Scanner;

public class CountCompleteTreeNodes {
    /*
        LeetCode (80/150)
        https://leetcode.com/problems/count-complete-tree-nodes/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity* : O((log n)^2)
        Auxiliary Space* : O(log n)
        *Assuming balanced binary tree

        Example 1:
        Input: root = [1,2,3,4,5,6]
        Output: 6

        Example 2:
        Input: root = []
        Output: 0

        Example 3:
        Input: root = [1]
        Output: 1
    */

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMostHeight = getHeight(root, true);
        int rightMostHeight = getHeight(root, false);

        // if root is a complete binary tree
        if (leftMostHeight == rightMostHeight) {
            return (1 << leftMostHeight) - 1;
        }

        // else recurse to its subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode root, boolean leftMost) {
        // calculates the leftmost or rightmost height of root 
        int height = 0;
        while (root != null) {
            height++;
            root = leftMost ? root.left : root.right;
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        int ans = new CountCompleteTreeNodes().countNodes(root);
        System.out.println(ans);
    }
}
