package binary_tree_general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearchTreeIterator {
    /*
        LeetCode (79/150)
        https://leetcode.com/problems/binary-search-tree-iterator/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input
        ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
        [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
        Output
        [null, 3, 7, true, 9, true, 15, true, 20, false]

        Explanation
        BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
        bSTIterator.next();    // return 3
        bSTIterator.next();    // return 7
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 9
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 15
        bSTIterator.hasNext(); // return True
        bSTIterator.next();    // return 20
        bSTIterator.hasNext(); // return False
    */

    class BSTIterator {
        private List<Integer> list;
        private int index;

        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            this.index = 0;
            inOrder(root);   
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
        
        public int next() {
            if (!hasNext()) {
                return -1;
            }
            return list.get(index++);
        }   
        
        public boolean hasNext() {
            return index < list.size();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        TreeNode root = TreeNode.createBinaryTree(input);
        BinarySearchTreeIterator obj = new BinarySearchTreeIterator();
        BSTIterator bSTIterator = obj.new BSTIterator(root);

        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());   
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());   
        System.out.println(bSTIterator.hasNext()); 
        System.out.println(bSTIterator.next());    
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());    
        System.out.println(bSTIterator.hasNext());
    }
}
