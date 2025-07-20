package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinations {
    /*
        LeetCode (102/150)
        https://leetcode.com/problems/combinations/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(k * C(n,k))
        Auxiliary Space : O(k)

        Example 1:
        Input: n = 4, k = 2
        Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        Explanation: There are 4 choose 2 = 6 total combinations.
        Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

        Example 2:
        Input: n = 1, k = 1
        Output: [[1]]
        Explanation: There is 1 choose 1 = 1 total combination.
    */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(
        int n, int k, int start, List<Integer> combination, List<List<Integer>> list
    ) {
        // a combination is generated
        if (k == 0) {
            // add a deep copy (instead of reference)
            list.add(new ArrayList<>(combination));
            return;
        }

        // generate combinations in increasing order
        for (int i = start; i <= n; i++) {
            combination.add(i);                             // add a number
            backtrack(n, k-1, i+1, combination, list);      // generate
            combination.remove(combination.size() - 1);     // backtrack
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        List<List<Integer>> ans = new Combinations().combine(n, k);
        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
