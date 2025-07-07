package array_or_string;

import java.util.Scanner;

public class FirstOccurenceInString {
    /*
        Leetcode (23/150)
        https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n), but in average, TC is O(m + n)
        Auxiliary Space : O(1)

        Example 1:
        Input: haystack = "sadbutsad", needle = "sad"
        Output: 0
        Explanation: "sad" occurs at index 0 and 6.
        The first occurrence is at index 0, so we return 0.

        Example 2:
        Input: haystack = "leetcode", needle = "leeto"
        Output: -1
        Explanation: "leeto" did not occur in "leetcode", so we return -1.
    */

    // length of character set (lower case English letters)
    private static final int D = 26;

    // a prime no. to reduce collision
    private static final int Q = 101;

    public int strStr(String haystack, String needle) {
        // Rabin Karp Algorithm
        int n = haystack.length();
        int m = needle.length();
        if (m > n) {
            return -1;
        }

        int p = 0;  // hash value of pattern or needle
        int t = 0;  // hash value of substring (of size m) of text or haystack 
        int h = 1;  // high order digit multiplier

        // compute (D ^ m-1) % Q as multiplier
        for (int i = 0; i < m-1; i++) {
            h = (h * D) % Q;
        }

        // compute hash values of pattern & the first substring of text
        for (int i = 0; i < m; i++) {
            p = (D * p + needle.charAt(i)) % Q;
            t = (D * t + haystack.charAt(i)) % Q;
        }

        for (int i = 0; i <= n-m; i++) {
            if (p == t) {
                // if hash values match, go for char by char comparison
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (needle.charAt(j) != haystack.charAt(i+j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
            // use rolling hash to compute hash value of the next substring
            if (i < n-m) {
                t = (D * (t - haystack.charAt(i) * h) + haystack.charAt(i+m)) % Q;
                if (t < 0) {
                    t += Q;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        sc.close();

        int i = new FirstOccurenceInString().strStr(haystack, needle);
        System.out.println(i);
    }
}
