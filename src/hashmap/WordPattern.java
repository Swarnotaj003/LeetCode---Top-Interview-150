package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
    /*
        LeetCode (41/150)
        https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: pattern = "abba", s = "dog cat cat dog"
        Output: true
        Explanation:
        The bijection can be established as:
        'a' maps to "dog".
        'b' maps to "cat".

        Example 2:
        Input: pattern = "abba", s = "dog cat cat fish"
        Output: false

        Example 3:
        Input: pattern = "aaaa", s = "dog cat cat dog"
        Output: false
    */

    public boolean wordPattern(String pattern, String s) {
        // char in pattern -> word in s
        HashMap<Character, String> map = new HashMap<>();
        int n = pattern.length();
        String[] words = s.split(" ");
        if (n != words.length) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else if (map.containsValue(word)) {
                return false;
            }
            map.put(ch, word);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pattern = sc.nextLine();
        String s = sc.nextLine();
        sc.close();

        boolean ans = new WordPattern().wordPattern(pattern, s);
        System.out.println(ans);
    }
}
