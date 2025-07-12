package stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    /*
        LeetCode (52/150)
        https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "(]"
        Output: false

        Example 3:
        Input: s = "([])"
        Output: true
    */

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            char curr= s.charAt(i);
            if (!stk.isEmpty()) {
                char prev = stk.peek();
                if (isValidPair(prev, curr)) {
                    stk.pop();
                    continue;
                }
            }
            stk.push(curr);
        }
        return stk.isEmpty();
    }

    private boolean isValidPair(char left, char right) {
        return (left == '(' && right == ')')
            || (left == '{' && right == '}')
            || (left == '[' && right == ']');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        boolean ans = new ValidParentheses().isValid(s);
        System.out.println(ans);
    }
}
