package binary_search_tree;

import java.util.Scanner;

import binary_tree_general.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    /*
        LeetCode (86/150)
        https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [4,2,6,1,3]
        Output: 1

        Example 2:
        Input: root = [1,0,48,null,null,12,49]
        Output: 1
    */

    private int minDiff;    // min. absolute difference
    private TreeNode prev;  // inOrder predecessor

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrder(root);
        return minDiff;        
    }

    private void inOrder(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inOrder(curr.left);
        if (prev != null) {
            minDiff = Math.min(curr.val - prev.val, minDiff);
        }
        prev = curr;
        inOrder(curr.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // construct the BST
        TreeNode root = TreeNode.createBinaryTree(input);
        int ans = new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root);
        System.out.println(ans);
    }
}
