package binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binary_tree_general.TreeNode;

public class BinaryTreeZigZagLevelOrderTraversal {
    /*
        LeetCode (85/150)
        https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[20,9],[15,7]]

        Example 2:
        Input: root = [1]
        Output: [[1]]

        Example 3:
        Input: root = []
        Output: []
    */

    // Using BFS method
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if (root == null) {
            return zigzag;
        }

        boolean leftToRight = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int nodes = q.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < nodes; i++) {
                TreeNode curr = q.poll();
                if (leftToRight) {
                    currLevel.add(curr.val);
                } else {
                    currLevel.add(0, curr.val);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            leftToRight = !leftToRight;
            zigzag.add(currLevel);
        }
        return zigzag;
    }

    // Using DFS method
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> zigzag = new ArrayList<>();
        dfs(root, 0, zigzag, true);
        return zigzag;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list, boolean leftToRight) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }

        if (leftToRight) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0, root.val);
        }
        dfs(root.left, level + 1, list, !leftToRight);
        dfs(root.right, level + 1, list, !leftToRight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        BinaryTreeZigZagLevelOrderTraversal obj = new BinaryTreeZigZagLevelOrderTraversal();
        List<List<Integer>> list1 = obj.zigzagLevelOrderBFS(root);
        List<List<Integer>> list2 = obj.zigzagLevelOrderDFS(root);

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
