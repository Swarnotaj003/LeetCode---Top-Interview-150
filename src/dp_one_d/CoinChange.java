package dp_one_d;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    /*
        LeetCode (140/150)
        https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(amount * n)
        Auxiliary Space : O(amount)

        Example 1:
        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1

        Example 2:
        Input: coins = [2], amount = 3
        Output: -1

        Example 3:
        Input: coins = [1], amount = 0
        Output: 0
    */


    public int coinChange(int[] coins, int amount) {
        // dp[i] = min. coins required to make up amount i
        int[] dp = new int[amount + 1];

        // initialize with max. value to indicate unreachability
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;  // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // use current coin to make up amount i
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // return -1 if the amount is unreachable
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int total = sc.nextInt();
        sc.close();

        int ans = new CoinChange().coinChange(nums, total);
        System.out.println(ans);
    }
}
