package array_or_string;

import java.util.Scanner;

class MergeSortedArray {
    /*
        Leetcode (1/150)
        https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m + n)
        Auxiliary Space : O(1)

        Example:
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
    */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] nums1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        sc.close();

        new MergeSortedArray().merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}