package dp_multi_d;

import java.util.Scanner;

public class MinimumPathSum {
    /*
        LeetCode (143/150)
        https://leetcode.com/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(1)

        Example 1:
        Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
        Output: 7
        Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

        Example 2:
        Input: grid = [[1,2,3],[4,5,6]]
        Output: 12
    */

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j] = min. path sum to reach grid[i][j]
        // here dp[][] is implemented on grid[][] itself

        // any point on first row is reachable by right moves only
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        
        // any point on first column is reachable by down moves only
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // choose the min. of paths coming from top and left
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int ans = new MinimumPathSum().minPathSum(grid);
        System.out.println(ans);
    }
}
