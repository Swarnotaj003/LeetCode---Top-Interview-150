package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    /*
        LeetCode (121/150)
        https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log k)
        Auxiliary Space : O(k)

        Example 1:
        Input: nums = [3,2,1,5,6,4], k = 2
        Output: 5

        Example 2:
        Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        Output: 4
    */

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < n; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int ans = new KthLargestElementInAnArray().findKthLargest(nums, k);
        System.out.println(ans);
    }
}
