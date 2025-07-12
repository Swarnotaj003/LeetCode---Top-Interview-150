package stack;

import java.util.Stack;

/*
    LeetCode (54/150)
    https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150

    Time Complexity : O(1)
    Auxiliary Space : O(n)

    Example:
    Input
    ["MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
*/

class MinStack {
    // to store (val, min. no. below val)
    Stack<int[]> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (!minStack.isEmpty()) {
            minStack.push(new int[] {val, Math.min(val, minStack.peek()[1])});
        } else {
            minStack.push(new int[] {val, val});
        }
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek()[0];
    }
    
    public int getMin() {
        return minStack.peek()[1];
    }
}


public class MinStackDesign {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
