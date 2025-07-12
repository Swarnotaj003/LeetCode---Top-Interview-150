package intervals;

import java.util.Arrays;
import java.util.Scanner;

public class MinNoOfArrowsToBurstBalloons {
    /*
        LeetCode (51/150)
        https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: points = [[10,16],[2,8],[1,6],[7,12]]
        Output: 2
        Explanation: The balloons can be burst by 2 arrows:
        - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
        - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

        Example 2:
        Input: points = [[1,2],[3,4],[5,6],[7,8]]
        Output: 4
        Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
    */

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int n = points.length;
        int minArrows = 1, currArrow = points[0][1];

        for (int i = 1; i < n; i++) {
            if (currArrow >= points[i][0]) {
                currArrow = Math.min(currArrow, points[i][1]);
            } else {
                minArrows++;
                currArrow = points[i][1];
            }
        }  
        return minArrows;
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

        int ans = new MinNoOfArrowsToBurstBalloons().findMinArrowShots(points);
        System.out.println(ans);
    }
}
