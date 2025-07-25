package math;

import java.util.Scanner;

public class PlusOne {
    /*
        LeetCode (132/150)
        https://leetcode.com/problems/plus-one/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Incrementing by one gives 4321 + 1 = 4322.
        Thus, the result should be [4,3,2,2].

        Example 2:
        Input: digits = [9]
        Output: [1,0]
        Explanation: The array represents the integer 9.
        Incrementing by one gives 9 + 1 = 10.
        Thus, the result should be [1,0].
    */

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--){
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int[] ans = new PlusOne().plusOne(nums);
        for (int num : ans) {
            System.out.print(num);
        }
        System.out.println();
    }
}
