package binary_tree_general;

import java.util.Scanner;

public class BinaryTreeMaximumPathSum {
    /*
        LeetCode (78/150)
        https://leetcode.com/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(h); h = height of the tree

        Example 1:
        Input: root = [1,2,3]
        Output: 6
        Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

        Example 2:
        Input: root = [-10,9,20,null,null,15,7]
        Output: 42
        Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
    */

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // get left & right max path sums, ignore negative paths
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        // compare max path sum with current max path through root 
        maxSum = Math.max(maxSum, root.val + leftMax + rightMax);

        // return max path from root to leaf
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        int ans = new BinaryTreeMaximumPathSum().maxPathSum(root);
        System.out.println(ans);
    }
}
