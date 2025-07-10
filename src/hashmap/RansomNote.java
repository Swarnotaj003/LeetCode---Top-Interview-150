package hashmap;

import java.util.Scanner;

public class RansomNote {
    /*
        LeetCode (39/150)
        https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m + n)
        Auxiliary Space : O(1)

        Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false

        Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false

        Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true
    */

    public boolean canConstruct(String ransomNote, String magazine) {
        // to store frequency of lowercase English letters
        int[] count = new int[26];

        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0) {
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

        boolean ans = new RansomNote().canConstruct(s, t);
        System.out.println(ans);
    }
}
