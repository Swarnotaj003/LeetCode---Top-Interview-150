package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxPointsOnALine {
    /*
        LeetCode (136/150)
        https://leetcode.com/problems/max-points-on-a-line/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n)

        Example 1:
        Input: points = [[1,1],[2,2],[3,3]]
        Output: 3

        Example 2:
        Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        Output: 4
    */

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 0;
        for (int i = 0; i < n-1; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int currMax = 0;
            int same = 0;
            for (int j = i+1; j < n; j++) {
                double dx = (double)(points[i][0] - points[j][0]);
                double dy = (double)(points[i][1] - points[j][1]);
                if (dy == 0 && dx == 0) {
                    same++;
                } else {
                    double slope = 0.0;
                    if (dx == 0.0) {
                        slope = Double.POSITIVE_INFINITY;
                    } else if (dy == 0) {
                        slope = 0.0;
                    } else {
                        slope = dy / dx;
                    }
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    currMax = Math.max(currMax, map.get(slope));
                }
            }
            maxPoints = Math.max(maxPoints, currMax + same);
        }
        return maxPoints + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        sc.close();

        int ans = new MaxPointsOnALine().maxPoints(points);
        System.out.println(ans);
    }
}
