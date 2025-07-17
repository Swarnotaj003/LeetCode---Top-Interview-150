package binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binary_tree_general.TreeNode;

public class AverageOfLevelsInBinaryTree {
    /*
        LeetCode (83/150)
        https://leetcode.com/problems/average-of-levels-in-binary-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [3.00000,14.50000,11.00000]
        Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
        Hence return [3, 14.5, 11].

        Example 2:
        Input: root = [3,9,20,15,7]
        Output: [3.00000,14.50000,11.00000]
    */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int nodes = q.size();   // no. of nodes in the current level
            double sum = 0.0;       // sum of nodes in the current level

            for (int i = 0; i < nodes; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                
                // add children if not null
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            averages.add(sum / nodes);
        }
        return averages;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        List<Double> list = new AverageOfLevelsInBinaryTree().averageOfLevels(root);
        for (double num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
