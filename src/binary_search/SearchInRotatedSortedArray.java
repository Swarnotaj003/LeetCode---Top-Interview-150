package binary_search;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
    /*
        LeetCode (117/150)
        https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [4,5,6,7,0,1,2], target = 0
        Output: 4

        Example 2:
        Input: nums = [4,5,6,7,0,1,2], target = 3
        Output: -1

        Example 3:
        Input: nums = [1], target = 0
        Output: -1
    */

    public int search(int[] nums, int target) {
        int pivot = findRotationPoint(nums);
        int pos = binarySearch(nums, 0, pivot, target);
        if (pos > -1) {
            return pos;
        }
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private int findRotationPoint(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[nums.length - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
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

        int ans = new SearchInRotatedSortedArray().search(nums, target);
        System.out.println(ans);
    }
}
