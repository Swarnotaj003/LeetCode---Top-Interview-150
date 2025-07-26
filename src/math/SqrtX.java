package math;

import java.util.Scanner;

public class SqrtX {
    /*
        LeetCode (134/150)
        https://leetcode.com/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log x)
        Auxiliary Space : O(1)

        Example 1:
        Input: x = 4
        Output: 2

        Example 2:
        Input: x = 8
        Output: 2
    */

    public int mySqrt(int x) {
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = new SqrtX().mySqrt(sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
