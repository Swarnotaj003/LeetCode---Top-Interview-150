package dp_one_d;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    /*
        LeetCode (141/150)
        https://leetcode.com/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n)

        Example 1:
        Input: nums = [10,9,2,5,3,7,101,18]
        Output: 4
        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

        Example 2:
        Input: nums = [0,1,0,3,2,3]
        Output: 4

        Example 3:
        Input: nums = [7,7,7,7,7,7,7]
        Output: 1
    */

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        // dp[i] = length of LIS ending with arr[i]
        int dp[] = new int[n];
        // initialize with min. possible length of LIS
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            // maintain ascending order
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // update length of LIS
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new LongestIncreasingSubsequence().lengthOfLIS(nums);
        System.out.println(ans);
    }
}
