package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfAPhoneNumber {
    /*
        LeetCode (101/150)
        https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(3^n * n)
        Auxiliary Space : O(3^n + n)

        * n -> length of digits, m 

        Example 1:
        Input: digits = "23"
        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        Example 2:
        Input: digits = ""
        Output: []

        Example 3:
        Input: digits = "2"
        Output: ["a","b","c"]
    */

    // buttons of a keypad mobile phone
    // number -> (letters)
    private final static char[][] BUTTONS = {
        {}, {}, {'a', 'b', 'c'},
        {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, 
        {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        generate(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void generate(String digits, int index, StringBuilder sb, List<String> list) {
        // sb holds a generated combination
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }

        // try all possible options
        int num = digits.charAt(index) - '0';
        for (char ch : BUTTONS[num]) {
            // use the option & generate
            sb.append(ch);      
            generate(digits, index + 1, sb, list);

            // revert the option (backtrack)
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        sc.close();

        List<String> ans = new LetterCombinationsOfAPhoneNumber().letterCombinations(digits);
        for (String s : ans) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
