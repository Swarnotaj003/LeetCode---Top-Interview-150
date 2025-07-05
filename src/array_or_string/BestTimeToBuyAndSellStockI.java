package array_or_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStockI {
    /*
        Leetcode (7/150)
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

        Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.
    */  

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cost = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            cost = Math.min(cost, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - cost);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BufferedReader br;
        int n, prices[] = new int[0];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            prices = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(input[i]);
            }
            br.close();
        } catch (NumberFormatException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        
        int ans = new BestTimeToBuyAndSellStockI().maxProfit(prices);
        System.out.println(ans);
    }
}
