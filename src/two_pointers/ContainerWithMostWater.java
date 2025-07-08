package two_pointers;

import java.util.Scanner;

public class ContainerWithMostWater {
    /*
        LeetCode (28/150)
        https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        
        Example 2:
        Input: height = [1,1]
        Output: 1  
    */

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int maxWater = 0;

        while (left < right) {
            maxWater = Math.max(maxWater, Math.min(leftMax, rightMax) * (right - left));
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new ContainerWithMostWater().maxArea(nums);
        System.out.println(ans);
    }
}
