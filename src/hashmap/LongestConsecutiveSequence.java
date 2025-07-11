package hashmap;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    /*
        LeetCode (47/150)
        https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

        Example 2:
        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9

        Example 3:
        Input: nums = [1,0,1,2]
        Output: 3
    */

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxConsecutive = 0;
        for (int num : set) {
            if (set.contains(num-1)) {
                continue;
            }
            int currConsecutive = 1;
            while (set.contains(num + currConsecutive)) {
                currConsecutive++;
            }
            maxConsecutive = Math.max(maxConsecutive, currConsecutive);
        }
        return maxConsecutive;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int ans = new LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println(ans);
    }
}