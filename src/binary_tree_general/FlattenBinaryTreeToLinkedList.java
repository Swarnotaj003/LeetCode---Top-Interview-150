package binary_tree_general;

import java.util.Scanner;

public class FlattenBinaryTreeToLinkedList {
    /*
        LeetCode (75/150)
        https://leetcode.com/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [1,2,5,3,4,null,6]
        Output: [1,null,2,null,3,null,4,null,5,null,6]

        Example 2:
        Input: root = []
        Output: []

        Example 3:
        Input: root = [0]
        Output: [0]
    */

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // flatten the subtrees
        flatten(root.left);
        flatten(root.right);

        if (root.left != null) {
            // right pointer of last node in left subtree points to right subtree
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;

            // set right pointer to follow pre-order
            root.right = root.left;
        } 
        
        // left pointer must contain nothing
        root.left = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root.toString());
    }
}
