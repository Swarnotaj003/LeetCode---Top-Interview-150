package dp_one_d;

import java.util.Scanner;

public class ClimbingStairs {
    /*
        LeetCode (137/150)
        https://leetcode.com/problems/climbing-stairs/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

        Example 2:
        Input: n = 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
    */

    public int climbStairs(int n) {
        // dp[i] = no. of ways to climb to 'i'th step
        int[] dp = new int[n+1];

        // base cases
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            // each time climb either 1 or 2 steps
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = new ClimbingStairs().climbStairs(sc.nextInt());
        System.out.println(ans);
        sc.close();        
    }
}
