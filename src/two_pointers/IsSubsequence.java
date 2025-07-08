package two_pointers;

import java.util.Scanner;

public class IsSubsequence {
    /*
        LeetCode (26/150)
        https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)
    
        Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true

        Example 2:
        Input: s = "axc", t = "ahbgdc"
        Output: false   
    */

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            i++;
        }
        return j == m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        boolean ans = new IsSubsequence().isSubsequence(s, t);
        System.out.println(ans);
    }
}
