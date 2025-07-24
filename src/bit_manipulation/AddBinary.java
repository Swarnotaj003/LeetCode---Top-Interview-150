package bit_manipulation;

import java.util.Scanner;

public class AddBinary {
    /*
        LeetCode (125/150)
        https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(max(m, n))
        Auxiliary Space : O(max(m, n))

        Example 1:
        Input: a = "11", b = "1"
        Output: "100"

        Example 2:
        Input: a = "1010", b = "1011"
        Output: "10101"
    */

    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m < n) {
            a = padZeroes(a, n - m);
        } else if (m > n) {
            b = padZeroes(b, m - n);
        }

        StringBuilder sb = new StringBuilder();
        int size = Math.max(m, n), carry = 0;
        
        for (int i = size - 1; i >= 0; i--) {
            int bit = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            sb.append(bit % 2);
            carry = bit/2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private String padZeroes(String s, int zeroes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroes; i++) {
            sb.append('0');
        }
        return sb.append(s).toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();

        String s = new AddBinary().addBinary(a, b);
        System.out.println(s);
    }
}
