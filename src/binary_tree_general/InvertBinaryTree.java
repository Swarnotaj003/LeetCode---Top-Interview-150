package binary_tree_general;

import java.util.Scanner;

public class InvertBinaryTree {
    /*
        LeetCode (70/150)
        https://leetcode.com/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

        Example 2:
        Input: root = [2,1,3]
        Output: [2,3,1]
    */

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        // create the binary tree
        TreeNode root = TreeNode.createBinaryTree(input);

        TreeNode inverted = new InvertBinaryTree().invertTree(root);
        System.out.println(inverted.toString());
    }
}
