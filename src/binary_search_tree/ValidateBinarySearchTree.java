package binary_search_tree;

import java.util.Scanner;

import binary_tree_general.TreeNode;

public class ValidateBinarySearchTree {
    /*
        LeetCode (88/150)
        https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [2,1,3]
        Output: true

        Example 2:
        Input: root = [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.
    */

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long min, long max){
        if (root == null) {
            return true;
        }
        if (!(root.val > min && root.val < max)) {
            return false;
        }
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // construct the BST
        TreeNode root = TreeNode.createBinaryTree(input);
        boolean ans = new ValidateBinarySearchTree().isValidBST(root);
        System.out.println(ans);
    }
}
