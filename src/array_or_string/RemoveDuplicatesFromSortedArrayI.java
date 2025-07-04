package array_or_string;

import java.util.Scanner;

class RemoveDuplicatesFromSortedArrayI {
    /*
        Leetcode (3/150)
        https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example :
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
    */

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
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

        sc.close();

        int k = new RemoveDuplicatesFromSortedArrayI().removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
