package hashmap;

import java.util.Scanner;

public class IsomorphicStrings {
    /*
        LeetCode (40/150)
        https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "egg", t = "add"
        Output: true
        Explanation:
        The strings s and t can be made identical by:
        Mapping 'e' to 'a'.
        Mapping 'g' to 'd'.

        Example 2:
        Input: s = "foo", t = "bar"
        Output: false

        Example 3:
        Input: s = "paper", t = "title"
        Output: true
    */

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // to store the last index (1-based) of each ASCII character
        // that appeared in the strings s and t
        int[] setS = new int[128];
        int[] setT = new int[128];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (setS[s.charAt(i)] != setT[t.charAt(i)]) {
                return false;
            }
            setS[s.charAt(i)] = i+1;
            setT[t.charAt(i)] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        boolean ans = new IsomorphicStrings().isIsomorphic(s, t);
        System.out.println(ans);
    }
}
