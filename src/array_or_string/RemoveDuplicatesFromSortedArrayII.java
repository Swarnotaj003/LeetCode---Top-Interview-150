package array_or_string;

import java.util.Scanner;

public class RemoveDuplicatesFromSortedArrayII {
    /*
        Leetcode (4/150)
        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example :
        Input: nums = [0,0,1,1,1,1,2,3,3]
        Output: 7, nums = [0,0,1,1,2,3,3,_,_]
        Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
    */

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 1;
        int prev = nums[0];
        boolean twice = false;

        for (int i = 1; i < n; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                twice = false;
                nums[count++] = nums[i];
            } else if (!twice) {
                nums[count++] = nums[i];
                twice = true;
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

        sc.close();

        int k = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
