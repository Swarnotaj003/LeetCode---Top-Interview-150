package array_or_string;

import java.util.Scanner;

public class TrappingRainWater {
    /*
        Leetcode (16/150)
        https://leetcode.com/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6 
        
        Example 2:
        Input: height = [4,2,0,3,2,5]
        Output: 9
    */ 

    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = height[left], rightMax = height[right];
        int rainWater = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                rainWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                rainWater += rightMax - height[right];
            }
        }
        return rainWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        int ans = new TrappingRainWater().trap(nums);
        System.out.println(ans);
    }
}
