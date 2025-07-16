package binary_tree_general;

import java.util.Scanner;

public class SumRootToLeafNumbers {
    /*
        LeetCode (77/150)
        https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [1,2,3]
        Output: 25
        Explanation:
        The root-to-leaf path 1->2 represents the number 12.
        The root-to-leaf path 1->3 represents the number 13.
        Therefore, sum = 12 + 13 = 25.

        Example 2:
        Input: root = [4,9,0,5,1]
        Output: 1026
        Explanation:
        The root-to-leaf path 4->9->5 represents the number 495.
        The root-to-leaf path 4->9->1 represents the number 491.
        The root-to-leaf path 4->0 represents the number 40.
        Therefore, sum = 495 + 491 + 40 = 1026.
    */

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumDFS(root, 0);
        return sum;
    }

    private void sumDFS(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        num = 10 * num + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        } 
        
        sumDFS(root.left, num);
        sumDFS(root.right, num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        int ans = new SumRootToLeafNumbers().sumNumbers(root);
        System.out.println(ans);
    }
}
