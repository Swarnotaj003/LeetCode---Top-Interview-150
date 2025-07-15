package binary_tree_general;

import java.util.Scanner;

public class SymmetricTree {
    /*
        LeetCode (71/150)
        https://leetcode.com/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [1,2,2,3,4,4,3]
        Output: true

        Example 2:
        Input: root = [1,2,2,null,3,null,3]
        Output: false
    */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirrorImage(root.left, root.right);
    }

    private boolean isMirrorImage(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirrorImage(left.right, right.left) && isMirrorImage(left.left, right.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // create the binary tree
        TreeNode root = TreeNode.createBinaryTree(input);

        boolean ans = new SymmetricTree().isSymmetric(root);
        System.out.println(ans);
    }
}
