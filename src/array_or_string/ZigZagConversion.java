package array_or_string;

import java.util.Scanner;

public class ZigZagConversion {
    /*
        Leetcode (22/150)
        https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        Explanation:
        P   A   H   N
        A P L S I I G
        Y   I   R

        Example 2:
        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
    */

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        int i = 0, j = 0;
        boolean goingDown = true;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int k = 0; k < numRows; k++) {
            rows[k] = new StringBuilder();
        }

        while (i < n) {
            rows[j].append(s.charAt(i));
            i++;
            if (goingDown) {
                if (j == numRows - 1) {
                    goingDown = false;
                    j--;
                } else {
                    j++;
                }
            } else {
                if (j == 0) {
                    goingDown = true;
                    j++;
                } else {
                    j--;
                }
            }
        }

        StringBuilder pattern = new StringBuilder();
        for (StringBuilder row : rows) {
            pattern.append(row);
        }
        return pattern.toString();
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int num = sc.nextInt();
        sc.close();

        String ans = new ZigZagConversion().convert(str, num);
        System.out.println(ans);
    }
}
