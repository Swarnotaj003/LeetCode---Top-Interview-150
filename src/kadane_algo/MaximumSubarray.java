package kadane_algo;

import java.util.Scanner;

public class MaximumSubarray {
    /*
        LeetCode (112/150)
        https://leetcode.com/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: The subarray [4,-1,2,1] has the largest sum 6.

        Example 2:
        Input: nums = [1]
        Output: 1
        Explanation: The subarray [1] has the largest sum 1.
        
        Example 3:
        Input: nums = [5,4,-1,7,8]
        Output: 23
        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
    */

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0], currSum = nums[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new MaximumSubarray().maxSubArray(nums);
        System.out.println(ans);
    }
}
