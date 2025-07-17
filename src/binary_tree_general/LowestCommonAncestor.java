package binary_tree_general;

import java.util.Scanner;

public class LowestCommonAncestor {
    /*
        LeetCode (81/150)
        https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(h); h = height of binary tree

        Example 1:
        Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        Output: 3
        Explanation: The LCA of nodes 5 and 1 is 3.

        Example 2:
        Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        Output: 5
        Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
    */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        
        // if both sub-trees contain p or q, then current root is lca
        if (leftLca != null && rightLca != null) {
            return root;
        }

        // else one of the subtrees have to be
        return leftLca == null ? rightLca : leftLca;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        TreeNode pNode = TreeNode.search(root, p);
        TreeNode qNode = TreeNode.search(root, q);
        TreeNode ans = new LowestCommonAncestor().lowestCommonAncestor(root, pNode, qNode);
        System.out.println(ans != null ? ans.val : "N");
    }
}
