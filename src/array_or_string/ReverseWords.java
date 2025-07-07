package array_or_string;

import java.util.Scanner;

public class ReverseWords {
    /*
        Leetcode (21/150)
        https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: s = "the sky is blue"
        Output: "blue is sky the"

        Example 2:
        Input: s = "  hello world  "
        Output: "world hello"
        Explanation: Your reversed string should not contain leading or trailing spaces.

        Example 3:
        Input: s = "a good   example"
        Output: "example good a"
        Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
    */

    public String reverseWords(String s) {
        String line = s.trim();
        String[] words = line.split(" ");
        int left = 0, right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();

        String ans = new ReverseWords().reverseWords(str);
        System.out.println(ans);
    }
}
