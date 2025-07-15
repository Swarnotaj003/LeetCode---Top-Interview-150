package binary_tree_general;

import java.util.Scanner;

public class SameTree {
    /*
        LeetCode (69/150)
        https://leetcode.com/problems/same-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(min(m, n))
        Auxiliary Space : O(min(m, n))

        Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true

        Example 2:
        Input: p = [1,2], q = [1,null,2]
        Output: false
    */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");
        sc.close();

        // create the binary tree
        TreeNode root1 = TreeNode.createBinaryTree(input1);
        TreeNode root2 = TreeNode.createBinaryTree(input2);

        boolean ans = new SameTree().isSameTree(root1, root2);
        System.out.println(ans);
    }
}
