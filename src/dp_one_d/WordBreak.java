package dp_one_d;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {
    /*
        LeetCode (139/150)
        https://leetcode.com/problems/word-break/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^3 + m*k)
        Auxiliary Space : O(n + m*k)

        Example 1:
        Input: s = "leetcode", wordDict = ["leet","code"]
        Output: true

        Example 2:
        Input: s = "applepenapple", wordDict = ["apple","pen"]
        Output: true

        Example 3:
        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        Output: false
    */

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);

        // dp[i] = whether the first i characters of s
        // is a valid combination of words from the set
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // if first j characters is a valid combination and 
                // the next substring upto 'i'th char is present in the set
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        String[] input = sc.nextLine().split(" ");
        List<String> words = Arrays.asList(input);
        sc.close();

        boolean ans = new WordBreak().wordBreak(s, words);
        System.out.println(ans);
    }
}
