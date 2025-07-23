package binary_search;

import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    /*
        LeetCode (120/150)
        https://leetcode.com/problems/median-of-two-sorted-arrays/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log min(m, n))
        Auxiliary Space : O(1)

        Example 1:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.

        Example 2:
        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int midA = (low + high)/2;
            int midB = (m + n + 1)/2 - midA;

            int maxLeftA = (midA == 0) ? Integer.MIN_VALUE : nums1[midA - 1];
            int minRightA = (midA == m) ? Integer.MAX_VALUE : nums1[midA];
            int maxLeftB = (midB == 0) ? Integer.MIN_VALUE : nums2[midB - 1];
            int minRightB = (midB == n) ? Integer.MAX_VALUE : nums2[midB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = midA - 1;
            } else {
                low = midA + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        sc.close();

        double ans = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}
