package sliding_window;

import java.util.Scanner;

public class LongestSubstringWithoutRepeatingChars {
    /*
        LeetCode (31/150)
        https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
        
        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    */

    public int lengthOfLongestSubstring(String s) {
        // to store frequency of each ASCII character
        int[] count = new int[128];
        int n = s.length(), maxLen = 0;
        int left = 0, right;

        for (right = 0; right < n; right++) {
            char ch = s.charAt(right);
            while (left < right && count[ch] > 0) {
                count[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            count[ch]++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        sc.close();

        int ans = new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(str);
        System.out.println(ans);
    }
}
