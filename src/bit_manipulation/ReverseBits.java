package bit_manipulation;

import java.util.Scanner;

public class ReverseBits {
    /*
        LeetCode (126/150)
        https://leetcode.com/problems/reverse-bits/?envType=study-plan-v2&envId=top-interview-150
        
        Time Complexity : O(32)
        Auxiliary Space : O(1)

        Example 1:
        Input: n = 43261596
        Output: 964176192
        Explanation:
        Integer	    Binary
        43261596	00000010100101000001111010011100
        964176192	00111001011110000010100101000000

        Example 2:
        Input: n = 2147483644
        Output: 1073741822
        Explanation:
        Integer	    Binary
        2147483644	01111111111111111111111111111100
        1073741822	00111111111111111111111111111110
    */

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            rev |= (n & 1);
            n >>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = new ReverseBits().reverseBits(sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
