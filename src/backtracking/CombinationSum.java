package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    /*
        LeetCode (104/150)
        https://leetcode.com/problems/combination-sum/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n)

        Example 1:
        Input: candidates = [2,3,6,7], target = 7
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.

        Example 2:
        Input: candidates = [2,3,5], target = 8
        Output: [[2,2,2,2],[2,3,3],[3,5]]
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, 0, new ArrayList<>(), combinations, target);
        return combinations;
    }

    private void backtrack(
        int[] nums, int index, List<Integer> combination, List<List<Integer>> list, int sum
    ) {
        // target sum reached
        if (sum == 0) {
            list.add(new ArrayList<>(combination));
            return;
        }

        // target sum not possible
        if (sum < 0) {
            return;
        }

        // generate ordered combinations with duplicates
        for (int i = index; i < nums.length; i++) {
            combination.add(nums[i]);
            backtrack(nums, i, combination, list, sum - nums[i]);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        sc.close();

        List<List<Integer>> ans = new CombinationSum().combinationSum(nums, k);
        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
