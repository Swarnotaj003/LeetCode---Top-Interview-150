package array_or_string;

import java.util.Scanner;

public class LongestCommonPrefix {
    /*
        Leetcode (20/150)
        https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n)
        Auxiliary Space : O(1)

        Example 1:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"

        Example 2:
        Input: strs = ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.      
    */

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        for (int i = 0; i < m; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        sc.close();

        String ans = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
