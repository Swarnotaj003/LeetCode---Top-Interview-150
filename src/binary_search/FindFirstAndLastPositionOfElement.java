package binary_search;

import java.util.Scanner;

public class FindFirstAndLastPositionOfElement {
    /*
        LeetCode (118/150)
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

        Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]
        
        Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]
    */

    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[] {first, last};
    }

    private int searchFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                pos = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pos;
    }

    private int searchLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int pos = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                pos = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();

        int[] ans = new FindFirstAndLastPositionOfElement().searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
