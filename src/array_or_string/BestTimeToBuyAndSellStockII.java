package array_or_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStockII {
    /*
        Leetcode (8/150)
        https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/1687279382/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.

        Example 2:
        Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Total profit is 4.
    */  

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n-1; i++) {
            if (prices[i] < prices[i+1]) {
                maxProfit += prices[i+1] - prices[i];
            }
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
        
        int ans = new BestTimeToBuyAndSellStockII().maxProfit(prices);
        System.out.println(ans);
    }
}
