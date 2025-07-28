package dp_multi_d;

import java.util.Scanner;

public class MaximalSquare {
    /*
        LeetCode (150/150)
        https://leetcode.com/problems/maximal-square/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(m*n)

        Example 1:
        Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        Output: 4

        Example 2:
        Input: matrix = [["0","1"],["1","0"]]
        Output: 1

        Example 3:
        Input: matrix = [["0"]]
        Output: 0
    */

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;

        // dp[i][j] = max. length of square in first i
        // and first j columns of matrix
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // check if the current cell is a bottom right corner of a larger square
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }
        sc.close();

        int ans = new MaximalSquare().maximalSquare(matrix);
        System.out.println(ans);
    }
}
