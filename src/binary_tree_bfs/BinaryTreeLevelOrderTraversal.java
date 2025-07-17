package binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binary_tree_general.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    /*
        LeetCode (84/150)
        https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[9,20],[15,7]]

        Example 2:
        Input: root = [1]
        Output: [[1]]

        Example 3:
        Input: root = []
        Output: []
    */

    // Using BFS method
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int nodes = q.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < nodes; i++) {
                TreeNode curr = q.poll();
                currLevel.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            levelOrder.add(currLevel);
        }
        return levelOrder;
    }

    // Using DFS method
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelOrder = new ArrayList<>();
        dfs(root, 0, levelOrder);
        return levelOrder;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> list1 = obj.levelOrderBFS(root);
        List<List<Integer>> list2 = obj.levelOrderDFS(root);

        for (List<Integer> l : list1) {
            System.out.print("( ");
            for (int num : l) {
                System.out.print(num + " ");
            }
            System.out.print(")");
        }
        System.out.println();

        for (List<Integer> l : list2) {
            System.out.print("( ");
            for (int num : l) {
                System.out.print(num + " ");
            }
            System.out.print(")");
        }
        System.out.println();
    }
}
