package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummaryRanges {
    /*
        LeetCode (48/150)
        https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: The ranges are:
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"

        Example 2:
        Input: nums = [0,2,3,4,6,8,9]
        Output: ["0","2->4","6","8->9"]
        Explanation: The ranges are:
        [0,0] --> "0"
        [2,4] --> "2->4"
        [6,6] --> "6"
        [8,9] --> "8->9"
    */

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, i = 0;
        List<String> ranges = new ArrayList<>();

        while (i < n) {
            int start = nums[i];
            while (i < n-1 && nums[i+1] == nums[i] + 1) {
                i++;
            }
            String range = (start == nums[i]) ? String.valueOf(nums[i]) : start + "->" + nums[i];
            ranges.add(range);
            i++;
        }
        return ranges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        List<String> ans = new SummaryRanges().summaryRanges(nums);
        for (String s : ans) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
