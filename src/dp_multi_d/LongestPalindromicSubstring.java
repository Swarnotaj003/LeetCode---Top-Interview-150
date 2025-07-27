package dp_multi_d;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    /*
        LeetCode (145/150)
        https://leetcode.com/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n^2)

        Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

        Example 2:
        Input: s = "cbbd"
        Output: "bb"
    */

    public String longestPalindrome(String s) {
        int n = s.length();

        // store the start & end of the longest palindrome
        int left = 0, right = 0;

        // dp[i][j] = whether s.substring(i, j+1) is palindrome or not
        boolean[][] dp = new boolean[n][n];

        // single length palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // double length palindromes
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                left = i;
                right = i+1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                // try expanding around small palindromes
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = new LongestPalindromicSubstring().longestPalindrome(sc.nextLine());
        System.out.println(ans);
        sc.close();
    }
}
