package stack;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
        LeetCode (55/150)
        https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: tokens = ["2","1","+","3","*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9

        Example 2:
        Input: tokens = ["4","13","5","/","+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6

        Example 3:
        Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        Output: 22
        Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5 = (0 + 17) + 5 = 17 + 5 = 22
    */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String curr = tokens[i];
            int left, right;
            switch (curr) {
                case "+":
                    right = stk.pop();
                    left = stk.pop();
                    stk.push(left + right);
                    break;
                case "-":
                    right = stk.pop();
                    left = stk.pop();
                    stk.push(left - right);
                    break;
                case "*":
                    right = stk.pop();
                    left = stk.pop();
                    stk.push(left * right);
                    break;
                case "/":
                    right = stk.pop();
                    left = stk.pop();
                    stk.push(left / right);
                    break;
                default:
                    stk.push(Integer.valueOf(curr));
            }
        } 
        return stk.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();

        int ans = new EvaluateReversePolishNotation().evalRPN(input);
        System.out.println(ans);
    }
}
