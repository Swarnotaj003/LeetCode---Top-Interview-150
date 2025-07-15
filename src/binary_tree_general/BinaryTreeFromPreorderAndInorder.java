package binary_tree_general;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeFromPreorderAndInorder {
    /*
        LeetCode (72/150)
        https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]

        Example 2:
        Input: preorder = [-1], inorder = [-1]
        Output: [-1]        
    */

    private int rootId;
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        // node value -> inOrder index
        this.map = new HashMap<>();

        // index of root in the current preOrder[] subarray
        this.rootId = 0;

        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }

        return build(preOrder, 0, n-1);
    }

    private TreeNode build(int[] preOrder, int left, int right) {
        if (left > right) {
            return null;
        }

        // first node in preOrder[] subarray is the root 
        int rootVal = preOrder[rootId++];

        // search for the root in inOrder[] subarray
        int mid = map.get(rootVal);
        
        // split inOrder[] following pre-order traversal
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preOrder, left, mid - 1);
        root.right = build(preOrder, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] preOrder = new int[n];
        int[] inOrder = new int[n];

        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }
        sc.close();

        TreeNode root = new BinaryTreeFromPreorderAndInorder().buildTree(preOrder, inOrder);
        System.out.println(root.toString());
    }
}
