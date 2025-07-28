package dp_multi_d;

import java.util.Scanner;

public class InterleavingString {
    /*
        LeetCode (146/150)
        https://leetcode.com/problems/interleaving-string/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(m*n)

        Example 1:
        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        Output: true
        Explanation: One way to obtain s3 is:
        Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
        Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".

        Example 2:
        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        Output: false

        Example 3:
        Input: s1 = "", s2 = "", s3 = ""
        Output: true    
    */

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }

        // dp[i][j] = whether first i chars of s1 & first j chars of s2
        // can form the first i+j chars of s3 or not
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // first column
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i-1) != s3.charAt(i-1)) {
                break;
            }
            dp[i][0] = true;
        }

        // first row
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j-1) != s3.charAt(j-1)) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // given a possible state, check if next chars of s1 & s3 are equal  
                if (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = true;
                } 
                // given a possible state, check if next chars of s2 & s3 are equal  
                if (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        sc.close();

        boolean ans = new InterleavingString().isInterleave(s1, s2, s3);
        System.out.println(ans);
    }
}
