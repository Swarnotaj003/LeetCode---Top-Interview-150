package binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import binary_tree_general.TreeNode;

public class KthSmallestElementInBST {
    /*
        LeetCode (87/150)
        https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(k)

        Example 1:
        Input: root = [3,1,4,null,2], k = 1
        Output: 1

        Example 2:
        Input: root = [5,3,6,2,4,null,null,1], k = 3
        Output: 3
    */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder, k);
        return inOrder.get(k-1);
    }

    private void inOrder(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list, k);
        if (list.size() == k) {
            return;
        }
        list.add(root.val);
        inOrder(root.right, list, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int k = sc.nextInt();
        sc.close();

        // construct the BST
        TreeNode root = TreeNode.createBinaryTree(input);
        int ans = new KthSmallestElementInBST().kthSmallest(root, k);
        System.out.println(ans);
    }
}
