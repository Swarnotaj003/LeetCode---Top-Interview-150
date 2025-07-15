package binary_tree_general;

import java.util.Scanner;

public class MaximumDepthOfBinaryTree {
    /*
        LeetCode (68/150)
        https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: 3

        Example 2:
        Input: root = [1,null,2]
        Output: 2
    */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // create the binary tree
        TreeNode root = TreeNode.createBinaryTree(input);

        int ans = new MaximumDepthOfBinaryTree().maxDepth(root.right);
        System.out.println(ans);
    }
}
