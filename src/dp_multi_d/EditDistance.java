package dp_multi_d;

import java.util.Scanner;

public class EditDistance {
    /*
        LeetCode (147/150)
        https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(m*n)

        Example 1:
        Input: word1 = "horse", word2 = "ros"
        Output: 3
        Explanation: 
        horse -> rorse (replace 'h' with 'r')
        rorse -> rose (remove 'r')
        rose -> ros (remove 'e')

        Example 2:
        Input: word1 = "intention", word2 = "execution"
        Output: 5
        Explanation: 
        intention -> inention (remove 't')
        inention -> enention (replace 'i' with 'e')
        enention -> exention (replace 'n' with 'x')
        exention -> exection (replace 'n' with 'c')
        exection -> execution (insert 'u')
    */
    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = min. edit distance between first
        // i chars of word1 and first j chars of word2
        int[][] dp = new int[m+1][n+1];

        // first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        // first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // no edits required if corresponding chars are same
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // else choose the min. of replacement, deletion and insertion
                else {
                    dp[i][j] = 1 + Math.min(
                        dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])
                    );
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        int ans = new EditDistance().minDistance(s1, s2);
        System.out.println(ans);
    }
}
