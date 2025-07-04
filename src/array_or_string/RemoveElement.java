package array_or_string;

import java.util.Scanner;

class RemoveElement {
    /*
        Leetcode (2/150)
        https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example :
        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
        Note that the five elements can be returned in any order.
        It does not matter what you leave beyond the returned k (hence they are underscores).
    */

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int val = sc.nextInt();

        sc.close();

        int k = new RemoveElement().removeElement(nums, val);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
