package dp_multi_d;

import java.util.Scanner;

public class UniquePathsII {
    /*
        LeetCode (144/150)
        https://leetcode.com/problems/unique-paths-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(m*n)

        Example 1:
        Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        Output: 2
        Explanation: There is one obstacle in the middle of the 3x3 grid above.
        There are two ways to reach the bottom-right corner:
        1. Right -> Right -> Down -> Down
        2. Down -> Down -> Right -> Right

        Example 2:
        Input: obstacleGrid = [[0,1],[0,0]]
        Output: 1
    */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // obstacle on entrance
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] = no. of unique paths to reach obstacleGrid[i][j]
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // any point on first row can be reached by right moves only
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        // any point on first column can be reached by down moves only
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // if no obstacle present
                // take the sum of paths from top & left
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
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

        int ans = new UniquePathsII().uniquePathsWithObstacles(grid);
        System.out.println(ans);
    }
}
