package divide_and_conquer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructQuadTree {
    /*
        LeetCode (110/150)
        https://leetcode.com/problems/construct-quad-tree/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(log n)

        Example 1:
        Input: grid = [[0,1],[1,0]]
        Output: [[0,1],[1,0],[1,1],[1,1],[1,0]]

        Example 2:
        Input: grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
        Output: [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
        Explanation: All values in the grid are not the same. We divide the grid into four sub-grids.
        The topLeft, bottomLeft and bottomRight each has the same value.
        The topRight have different values so we divide it into 4 sub-grids where each has the same value.
    */

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        // serialize a quad tree
        // level order traversal, each node = [isLeaf, val]
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            Queue<Node> q = new LinkedList<>();
            q.offer(this);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                sb.append("[" + (curr.isLeaf ? '1' : '0') + ", " + (curr.val ? '1' : '0') + "], ");
                if (!curr.isLeaf) {
                    q.offer(curr.topLeft);
                    q.offer(curr.topRight);
                    q.offer(curr.bottomLeft);
                    q.offer(curr.bottomRight);
                } else {
                    // sb.append("null, ").append("null, ").append("null, ").append("null, ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, n-1, 0, n-1);
    }

    private Node constructQuadTree(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd) {
            return new Node(grid[rowStart][colStart] == 1, true);
        }

        boolean hasSameValue = true;
        int currVal = grid[rowStart][colStart];
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] != currVal) {
                    hasSameValue = false;
                    break;
                }
            }
        }
        if (hasSameValue) {
            return new Node(currVal == 1, true);
        }

        Node root = new Node(true, false);
        int rowMid = (rowStart + rowEnd)/2;
        int colMid = (colStart + colEnd)/2;
        root.topLeft = constructQuadTree(grid, rowStart, rowMid, colStart, colMid);
        root.topRight = constructQuadTree(grid, rowStart, rowMid, colMid + 1, colEnd);
        root.bottomLeft = constructQuadTree(grid, rowMid + 1, rowEnd, colStart, colMid);
        root.bottomRight = constructQuadTree(grid, rowMid + 1, rowEnd, colMid + 1, colEnd);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        Node root = new ConstructQuadTree().construct(grid);
        System.out.println(root.toString());
    }
}