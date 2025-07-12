package stack;

import java.util.Scanner;
import java.util.Stack;

public class BasicCalculator {
    /*
        LeetCode (56/150)
        https://leetcode.com/problems/basic-calculator/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: s = "1 + 1"
        Output: 2

        Example 2:
        Input: s = " 2-1 + 2 "
        Output: 3

        Example 3:
        Input: s = "(1+(4+5+2)-3)+(6+8)"
        Output: 23
    */

    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        int currNum = 0, sign = 1, result = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // update current operand value
            if (Character.isDigit(ch)) {
                currNum = 10 * currNum + (ch - '0');
            } 

            // update sign for the next operand & reset the current
            else if (ch == '+') {
                result += sign * currNum;
                currNum = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * currNum;
                currNum = 0;
                sign = -1;
            } 
            
            // store the previous result & sign into the stack, then reset
            else if (ch == '(') {
                stk.push(result);
                stk.push(sign);
                sign = 1;
                result = 0;
            } 
            
            // update current result with previous values from stack
            else if (ch == ')') {
                result += sign * currNum;
                currNum = 0;
                result *= stk.pop();
                result += stk.pop();
            }
        }

        if (currNum != 0) {
            result += sign * currNum;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int ans = new BasicCalculator().calculate(s);
        System.out.println(ans);
    }
}
