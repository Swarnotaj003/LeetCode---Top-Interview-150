package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
     /*
        LeetCode (103/150)
        https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n * n!)
        Auxiliary Space : O(n)

        Example 1:
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        Example 2:
        Input: nums = [0,1]
        Output: [[0,1],[1,0]]
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, permutations);
        return permutations;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> list) {
        // a permutation is generated
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            list.add(permutation);
            return;
        }

        // rearrange nums to generate permutations
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);               // swap
            backtrack(nums, index + 1, list);   // generate
            swap(nums, i, index);               // revert (backtrack)
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        List<List<Integer>> ans = new Permutations().permute(nums);
        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
