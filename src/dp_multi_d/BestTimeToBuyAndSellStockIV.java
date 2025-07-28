package dp_multi_d;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockIV {
    /*
        LeetCode (149/150)
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(k*n)
        Auxiliary Space : O(k*n)

        Example 1:
        Input: k = 2, prices = [2,4,1]
        Output: 2
        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        
        Example 2:
        Input: k = 2, prices = [3,2,6,5,0,3]
        Output: 7
        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // dp[i][j] = max. profit till 'j'th day using atmost i transactions
        int[][] dp = new int[k+1][n];

        for (int t = 1; t <= k; t++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[t-1][i-1]);

                // take max. profit from holding and not holding the stock
                dp[t][i] = Math.max(dp[t][i-1], prices[i] - min);
            }
        }
        return dp[k][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int ans = new BestTimeToBuyAndSellStockIV().maxProfit(k, nums);
        System.out.println(ans);
    }
}
