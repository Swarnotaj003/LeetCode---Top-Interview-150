package array_or_string;

import java.util.Scanner;

public class RomanToInteger {
    /*
        Leetcode (17/150)
        https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3

        Example 2:
        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4        
    */ 

    private int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }

    public int romanToInt(String s) {
        int n = s.length();
        int num = 0;

        for (int i = 0; i < n; i++) {
            int val = getValue(s.charAt(i));
            if (i < n-1 && getValue(s.charAt(i+1)) > val) {
                num -= val;
            } else {
                num += val;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        int ans = new RomanToInteger().romanToInt(str);
        System.out.println(ans);
    }
}
