package hashmap;

import java.util.Scanner;

public class ValidAnagram {
    /*
        LeetCode (42/150)
        https://leetcode.com/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true

        Example 2:
        Input: s = "rat", t = "car"
        Output: false
    */

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // to store frequency of lowercase English letters
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0) {
                return false;
            }
        }

        // this part differentiates "Valid Anagram" from "Ransom Note"
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        boolean ans = new ValidAnagram().isAnagram(s, t);
        System.out.println(ans);
    }
}
