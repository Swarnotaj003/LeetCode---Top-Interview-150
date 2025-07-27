package dp_multi_d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle {
    /*
        LeetCode (142/150)
        https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(1)

        Example 1:
        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        Output: 11
        Explanation: The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11

        Example 2:
        Input: triangle = [[-10]]
        Output: -10
    */

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = 1; i < n; i++) {
            // length of 'i'th row in triangle is (i+1)
            List<Integer> prevRow = triangle.get(i-1);
            List<Integer> currRow = triangle.get(i);

            // set the path sum of fixed corner paths
            currRow.set(0, currRow.get(0) + prevRow.get(0));
            currRow.set(i, currRow.get(i) + prevRow.get(i-1));

            // for middle elements choose the min. parent path sum
            for (int j = 1; j < i; j++) {
                int val = currRow.get(j);
                currRow.set(j, val + Math.min(prevRow.get(j-1), prevRow.get(j)));
            }     
        }
        
        // the last row now contains min. path sum to reach the corresponding element
        int minPathSum = Integer.MAX_VALUE;
        for (int num : triangle.get(n-1)) {
            minPathSum = Math.min(minPathSum, num);
        }
        return minPathSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                temp.add(sc.nextInt());
            }
            triangle.add(temp);
        }
        sc.close();

        int ans = new Triangle().minimumTotal(triangle);
        System.out.println(ans);
    }
}
