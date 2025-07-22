package binary_search;

import java.util.Scanner;

public class FindPeakElement {
    /*
        LeetCode (116/150)
        https://leetcode.com/problems/find-peak-element/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 2
        Explanation: 3 is a peak element and your function should return the index number 2.

        Example 2:
        Input: nums = [1,2,1,3,5,6,4]
        Output: 5
        Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
    */

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new FindPeakElement().findPeakElement(nums);
        System.out.println(ans);
    }
}
