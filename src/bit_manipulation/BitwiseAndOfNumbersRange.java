package bit_manipulation;

import java.util.Scanner;

public class BitwiseAndOfNumbersRange {
    /*
        LeetCode (130/150)
        https://leetcode.com/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: left = 5, right = 7
        Output: 4

        Example 2:
        Input: left = 1, right = 2147483647
        Output: 0
    */

    public int rangeBitwiseAnd(int left, int right) {
        // any bit position that changes will result in 0
        // so the ans is common prefix of left & right
        int shifts = 0;
        while (left != right) {
            shifts++;
            left >>= 1;
            right >>= 1;
        }
        return left << shifts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        sc.close();

        int ans = new BitwiseAndOfNumbersRange().rangeBitwiseAnd(left, right);
        System.out.println(ans);
    }
}
