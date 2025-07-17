package binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binary_tree_general.TreeNode;

public class BinaryTreeRightSideView {
    /*
        LeetCode (82/150)
        https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [1,2,3,null,5,null,4]
        Output: [1,3,4]

        Example 2:
        Input: root = [1,2,3,4,null,null,null,5]
        Output: [1,3,4,5]

        Example 3:
        Input: root = [1,null,3]
        Output: [1,3]
    */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int nodes = q.size();       // no. of nodes in the current level
            TreeNode rightMost = null;  // rightmost node in the current level

            for (int i = 0; i < nodes; i++) {
                TreeNode curr = q.poll();
                
                // add children if not null
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                rightMost = curr;
            }

            // add right most node
            rightView.add(rightMost.val);
        }
        return rightView;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        List<Integer> list = new BinaryTreeRightSideView().rightSideView(root);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
