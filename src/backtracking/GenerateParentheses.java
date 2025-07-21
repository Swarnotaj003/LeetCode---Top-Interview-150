package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    /*
        LeetCode (106/150)
        https://leetcode.com/problems/generate-parentheses/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity*: O(C(n))
        Auxiliary Space : O(n)

        * C(n) = 4^n / n^1.5 ; Catalan number

        Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

        Example 2:
        Input: n = 1
        Output: ["()"]
    */

    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), parenthesis);
        return parenthesis;
    }

    private void backtrack(int n, int left, int right, StringBuilder sb, List<String> list) {
        // string generated
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }

        // first open all the parentheses one by one
        if (left < n) {
            sb.append('(');
            backtrack(n, left + 1, right, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

        // then close parentheses whenever possible
        if (right < left) {
            sb.append(')');
            backtrack(n, left, right + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        List<String> ans = new GenerateParentheses().generateParenthesis(n);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
