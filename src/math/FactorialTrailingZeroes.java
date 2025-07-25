package math;

import java.util.Scanner;

public class FactorialTrailingZeroes {
    /*
        LeetCode (133/150)
        https://leetcode.com/problems/factorial-trailing-zeroes/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: n = 3
        Output: 0
        Explanation: 3! = 6, no trailing zero.

        Example 2:
        Input: n = 5
        Output: 1
        Explanation: 5! = 120, one trailing zero.
    */

    public int trailingZeroes(int n) {
        // no. of trailing zeroes in n!
        // = no. of 10s as factors in n!
        // = min(no. of 2s, no. of 5s) as factors in n!
        if (n == 0) {
            return 0;
        }
        return n/5 + trailingZeroes(n/5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = new FactorialTrailingZeroes().trailingZeroes(sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
