package array_or_string;

import java.util.Scanner;

public class LengthOfLastWord {
    /*
        Leetcode (19/150)
        https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "Hello World"
        Output: 5
        Explanation: The last word is "World" with length 5.
        
        Example 2:
        Input: s = "   fly me   to   the moon  "
        Output: 4
        Explanation: The last word is "moon" with length 4.
    */

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int left = n-1, right = n-1;

        while (s.charAt(right) == ' ') {
            right--;
        }
        left = right;

        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        int num = new LengthOfLastWord().lengthOfLastWord(str);
        System.out.println(num);
    }
}
