package backtracking;

import java.util.Scanner;

public class NQueensII {
    /*
        LeetCode (105/150)
        https://leetcode.com/problems/n-queens-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n * n!)
        Auxiliary Space : O(n)

        Example 1:
        Input: n = 4
        Output: 2
        Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

        Example 2:
        Input: n = 1
        Output: 1
    */

    private int count;

    public int totalNQueens(int n) {
        count = 0;
        // board[i] => 'i'th queen placed at 'board[i]'th column of 'i'th row
        int[] board = new int[n];

        // generate all solutions
        solveNQueens(board, n, 0);
        return count;
    }

    private void solveNQueens(int[] board, int n, int k) {
        // all queens placed
        if (k == n) {
            count++;
            return;
        }

        // try to place kth queen in any of the columns
        for (int i = 0; i < n; i++) {
            if (canPlaceQueen(board, k, i)) {
                board[k] = i;
                solveNQueens(board, n, k+1);
            }
        }
    }

    // to check if 'k'th queen can be placed in 'i'th column 
    private boolean canPlaceQueen(int[] board, int k, int i) {
        for (int j = 0; j < k; j++) {
            // return false if 'i'th column 
            // or corresponding diagonal (slope = +/-1) is occupied
            if (board[j] == i || Math.abs(board[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int ans = new NQueensII().totalNQueens(n);
        System.out.println(ans);
    }
}
