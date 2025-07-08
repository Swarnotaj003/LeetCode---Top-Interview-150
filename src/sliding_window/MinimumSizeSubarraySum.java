package sliding_window;

import java.util.Scanner;

public class MinimumSizeSubarraySum {
    /*
        LeetCode (30/150)
        https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1690799177/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: target = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: The subarray [4,3] has the minimal length under the problem constraint.

        Example 2:
        Input: target = 11, nums = [1,2,3,4,5]
        Output: 3
        Explanation: The subarray [3,4,5] has the minimal length under the problem constraint.
    */

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minSize = n+1, currSum = 0;
        int left = 0, right;

        for (right = 0; right < n; right++) {
            currSum += nums[right];
            while (currSum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                currSum -= nums[left];
                left++;
            }
        }
        return minSize == n+1 ? 0 : minSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int minSum = sc.nextInt();
        sc.close();

        int ans = new MinimumSizeSubarraySum().minSubArrayLen(minSum, nums);
        System.out.println(ans);
    }
}
