package array_or_string;

import java.util.Scanner;

public class IntegerToRoman {
    /*
        Leetcode (18/150)
        https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(1)
        Auxiliary Space : O(1)

        Example 1:
        Input: num = 3749
        Output: "MMMDCCXLIX"

        Example 2:
        Input: num = 58
        Output: "LVIII"       
    */

    private String[] thousands = {"", "M", "MM", "MMM"};
    private String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[(num % 1000) / 100]);
        roman.append(tens[(num % 100) / 10]);
        roman.append(ones[num % 10]);

        return roman.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.close();

        String ans = new IntegerToRoman().intToRoman(num);
        System.out.println(ans);
    }
}
