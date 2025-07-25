package bit_manipulation;

import java.util.Scanner;

public class SingleNumberII {
    /*
        LeetCode (129/150)
        https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150
        
        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [2,2,3,2]
        Output: 3

        Example 2:
        Input: nums = [0,1,0,1,0,1,99]
        Output: 99
    */

    public int singleNumber(int[] nums) {
        int ones = 0;   // Tracks the bits that have appeared once
        int twos = 0;   // Tracks the bits that have appeared twice

        for (int num : nums) {
            // toggles the bits that have appeared an odd number of times
            // keeping the bits that have appeared twice unchanged
            ones ^= (num & ~twos);

            // toggles the bits that have appeared an even number of times,
            // keeping the bits that have appeared once unchanged
            twos ^= (num & ~ones);
        }
        return ones;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new SingleNumberII().singleNumber(nums);
        System.out.println(ans);
    }
}
