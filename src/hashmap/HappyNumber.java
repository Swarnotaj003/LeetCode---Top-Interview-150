package hashmap;

import java.util.Scanner;

public class HappyNumber {
    /*
        LeetCode (45/150)
        https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: n = 19
        Output: true
        Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

        Example 2:
        Input: n = 2
        Output: false        
    */

    public boolean isHappy(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1 || n == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        boolean ans = new HappyNumber().isHappy(num);
        System.out.println(ans);
    }
}
