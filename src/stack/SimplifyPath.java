package stack;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    /*
        LeetCode (53/150)
        https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: path = "/home/user/Documents/../Pictures"
        Output: "/home/user/Pictures"

        Example 2:
        Input: path = "/../"
        Output: "/"

        Example 3:
        Input: path = "/.../a/../b/c/../d/./"
        Output: "/.../b/d"
    */

    public String simplifyPath(String path) {
        // directories within the path are separated by '/'
        String[] files = path.split("/");
        Stack<String> stk = new Stack<>();
        int n = files.length;
        
        for (int i = 0; i < n; i++) {
            String curr = files[i];
            if (curr.equals("..") && !stk.isEmpty()) {
                stk.pop();
                continue;
            } 
            if (curr.length() > 0 && !curr.equals(".") && !curr.equals("..")) {
                stk.push(curr);
            }
        }
        
        // reverse the contents of stack
        Stack<String> revStk = new Stack<>();
        while (!stk.isEmpty()) {
            revStk.push(stk.pop());
        }

        StringBuilder newPath = new StringBuilder();
        while (!revStk.isEmpty()) {
            newPath.append("/");
            newPath.append(revStk.pop());
        }
        return newPath.isEmpty() ? "/" : newPath.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        String ans = new SimplifyPath().simplifyPath(s);
        System.out.println(ans);
    }
}
