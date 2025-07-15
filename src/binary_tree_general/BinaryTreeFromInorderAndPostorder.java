package binary_tree_general;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeFromInorderAndPostorder {
    /*
        LeetCode (73/150)
        https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        Output: [3,9,20,null,null,15,7]

        Example 2:
        Input: inorder = [-1], postorder = [-1]
        Output: [-1]
    */

    private int rootId;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        // node value -> inOrder index
        this.map = new HashMap<>();

        // index of root in the current postOrder[] subarray
        this.rootId = postOrder.length - 1;

        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }

        return build(postOrder, 0, n-1);
    }

    private TreeNode build(int[] postOrder, int left, int right) {
        if (left > right || rootId < 0) {
            return null;
        }

        // last node in postOrder[] subarray is the root 
        int rootVal = postOrder[rootId--];

        // search for the root in inOrder[] subarray
        int mid = map.get(rootVal);

        // split inOrder[] following post-order traversal
        TreeNode root = new TreeNode(rootVal);
        root.right = build(postOrder, mid + 1, right);
        root.left = build(postOrder, left, mid - 1);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] inOrder = new int[n];
        int[] postOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
        }
        sc.close();

        TreeNode root = new BinaryTreeFromInorderAndPostorder().buildTree(inOrder, postOrder);
        System.out.println(root.toString());
    }
}
