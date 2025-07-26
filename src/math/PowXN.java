package math;

import java.util.Scanner;

public class PowXN {
    /*
        LeetCode (135/150)
        https://leetcode.com/problems/powx-n/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: x = 2.00000, n = 10
        Output: 1024.00000

        Example 2:
        Input: x = 2.10000, n = 3
        Output: 9.26100

        Example 3:
        Input: x = 2.00000, n = -2
        Output: 0.25000
        Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
    */

    public double myPow(double x, int n) {
        return binaryExp(x, (long)n);
    }

    private double binaryExp(double x, double n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / binaryExp(x, -n);
        }

        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n-1)/2);
        }
        return binaryExp(x * x, n/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ans = new PowXN().myPow(sc.nextDouble(), sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
