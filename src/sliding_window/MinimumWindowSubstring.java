package sliding_window;

import java.util.Scanner;

public class MinimumWindowSubstring {
    /*
        LeetCode (33/150)
        https://leetcode.com/problems/minimum-window-substring/submissions/1691740331/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"
        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

        Example 2:
        Input: s = "a", t = "a"
        Output: "a"
        Explanation: The entire string s is the minimum window.

        Example 3:
        Input: s = "a", t = "aa"
        Output: ""
        Explanation: Both 'a's from t must be included in the window.
        Since the largest window of s only has one 'a', return empty string.
    */

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }

        // to store frequency of lowercase & uppercase English letters appearing in string 't'
        int[] originalCount = new int[52];
        for (char ch : t.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                originalCount[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                originalCount[ch - 'A' + 26]++;
            }
        }

        // to store frequency of lowercase & uppercase English letters appearing in current 'substring or window of s'
        int[] currentCount = new int[52];
        int required = 0, formed = 0;
        for (int i = 0; i < 52; i++) {
            if (originalCount[i] > 0) {
                required++;
            }
        }

        int start = 0;
        int minStart = 0, minLen = n+1;

        for (int end = 0; end < n; end++) {
            char last = s.charAt(end);
            int lastId = Character.isLowerCase(last) ? last - 'a' : last - 'A' + 26;
            currentCount[lastId]++;

            if (originalCount[lastId] > 0 && originalCount[lastId] == currentCount[lastId]) {
                formed++;
            }

            while (formed == required) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char first = s.charAt(start);
                int firstId = Character.isLowerCase(first) ? first - 'a' : first - 'A' + 26;
                currentCount[firstId]--;
                if (originalCount[firstId] > 0 && originalCount[firstId] > currentCount[firstId]) {
                    formed--;
                }
                start++;
            }
        }
        return minLen == n+1 ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        String ans = new MinimumWindowSubstring().minWindow(s, t);
        System.out.println(ans);
    }
}
