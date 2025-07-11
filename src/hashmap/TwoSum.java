package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    /*
        LeetCode (44/150)
        https://leetcode.com/problems/two-sum/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]

        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
    */

    public int[] twoSum(int[] nums, int target) {
        // number -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] {map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();

        int[] ans = new TwoSum().twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
