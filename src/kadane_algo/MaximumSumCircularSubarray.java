package kadane_algo;

import java.util.Scanner;

public class MaximumSumCircularSubarray {
    /*
        LeetCode (113/150)
        https://leetcode.com/problems/maximum-sum-circular-subarray/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [1,-2,3,-2]
        Output: 3
        Explanation: Subarray [3] has maximum sum 3.

        Example 2:
        Input: nums = [5,-3,5]
        Output: 10
        Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

        Example 3:
        Input: nums = [-3,-2,-3]
        Output: -2
        Explanation: Subarray [-2] has maximum sum -2.
    */

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], currMaxSum = nums[0];
        int minSum = nums[0], currMinSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            currMaxSum = Math.max(currMaxSum + num, num);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + num, num);
            minSum = Math.min(minSum, currMinSum);

            totalSum += num;
        }
        
        // in case of all negative numbers
        if (totalSum == minSum) {
            return maxSum;
        }

        // max sum subarray may or may not be wrapped around
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new MaximumSumCircularSubarray().maxSubarraySumCircular(nums);
        System.out.println(ans);
    }
}
