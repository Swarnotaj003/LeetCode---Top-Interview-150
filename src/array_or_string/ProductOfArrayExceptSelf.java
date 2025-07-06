package array_or_string;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {
    /*
        Leetcode (13/150)
        https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        NOTE: Use of division operator is not allowed

        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

        Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]   
    */ 

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 1, right = 1;

        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        for (int i = n-1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        int[] ans = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
