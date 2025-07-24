package bit_manipulation;

import java.util.Scanner;

public class NumberOfSetBits {
    /*
        LeetCode (127/150)
        https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(32)
        Auxiliary Space : O(1)

        Example 1:
        Input: n = 11
        Output: 3
        Explanation:
        The input binary string 1011 has a total of three set bits.

        Example 2:
        Input: n = 2147483645
        Output: 30
        Explanation:
        The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
    */

    public int hammingWeight(int n) {
        int setBits = 0;
        for (int i = 0; i < 32; i++) {
            setBits += n & 1;
            n >>= 1;
        }
        return setBits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = new NumberOfSetBits().hammingWeight(sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
