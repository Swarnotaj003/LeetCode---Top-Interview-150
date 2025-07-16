package binary_tree_general;

import java.util.Scanner;

public class PathSum {
    /*
        LeetCode (76/150)
        https://leetcode.com/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(h); h = height of binary tree

        Example 1:
        Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        Output: true

        Example 2:
        Input: root = [1,2,3], targetSum = 5
        Output: false

        Example 3:
        Input: root = [], targetSum = 0
        Output: false
    */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int targetSum = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        boolean ans = new PathSum().hasPathSum(root, targetSum);
        System.out.println(ans);
    }
}
