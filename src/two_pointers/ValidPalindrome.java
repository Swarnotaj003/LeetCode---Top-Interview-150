package two_pointers;

import java.util.Scanner;

public class ValidPalindrome {
    /*
        LeetCode (25/150)
        https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
    
        Time Complexity : O(n)
        Auxiliary Space : O(1)
    
        Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

        Example 2:
        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome. 
    */

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char first = s.charAt(left);
            char last = s.charAt(right);

            boolean isFirstCharValid = (first >= '0' && first <= '9') 
                || (first >= 'a' && first <= 'z') 
                || (first >= 'A' && first <= 'Z');
            boolean isLastCharValid = (last >= '0' && last <= '9') 
                || (last >= 'a' && last <= 'z') 
                || (last >= 'A' && last <= 'Z');

            if (!isFirstCharValid) {
                left++;
            } else if (!isLastCharValid) {
                right--;
            } else {
                first = (first >= 'A' && first <= 'Z') ? (char)(first + 32) : first;
                last = (last >= 'A' && last <= 'Z') ? (char)(last + 32) : last;
                if (first != last) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        boolean ans = new ValidPalindrome().isPalindrome(str);
        System.out.println(ans);
    }
}
