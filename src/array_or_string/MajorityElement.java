package array_or_string;

import java.util.Scanner;

public class MajorityElement {
    /*
        Leetcode (5/150)
        https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [3,2,3]
        Output: 3

        Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2
    */    

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int candidate = nums[0];

        // Boyer–Moore majority voting algorithm
        for (int i = 1; i < n; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        int ans = new MajorityElement().majorityElement(nums);
        System.out.println(ans);
    }
}
