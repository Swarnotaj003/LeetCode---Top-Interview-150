package math;

import java.util.Scanner;

public class PalindromeNumber {
    /*
        LeetCode (131/150)
        https://leetcode.com/problems/palindrome-number/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.

        Example 2:
        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    */

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int rev = 0;
        while (num > 0) {
            rev = 10 * rev + (num % 10);
            num = num / 10;
        }
        return rev == x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ans = new PalindromeNumber().isPalindrome(sc.nextInt());
        System.out.println(ans);
        sc.close();
    }
}
