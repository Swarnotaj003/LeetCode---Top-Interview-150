package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {
    /*
        LeetCode (50/150)
        https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]

        Example 2:
        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    */

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, i = 0;
        List<int[]> newIntervals = new ArrayList<>();

        // Case 1: No overlapping before merging intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        // Case 2: Overlapping and merging intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        newIntervals.add(newInterval);

        // Case 3: No overlapping after merging newInterval
        while (i < n) {
            newIntervals.add(intervals[i]);
            i++;
        }

        // Convert List to array
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[] newInterval = new int[2];
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();
        sc.close();
        System.out.println();

        int[][] newIntervals = new InsertInterval().insert(intervals, newInterval);
        for (int[] interval : newIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
