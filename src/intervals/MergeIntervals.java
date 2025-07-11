package intervals;

import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {
    /*
        LeetCode (49/150)
        https://leetcode.com/problems/merge-intervals/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

        Example 2:
        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    */

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = n;

        for (int i = 0; i < n-1; i++) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                count--;
            }
        }

        int[][] mergedIntervals = new int[count][2];
        int k = 0;
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                mergedIntervals[k++] = interval;
            }
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        sc.close();

        int[][] ans = new MergeIntervals().merge(nums);
        for (int[] x : ans) {
            System.out.print(x[0] + " " + x[1] + ", ");
        }
        System.out.println();
    }
}
