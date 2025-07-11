package hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class ContainsDuplicateII {
    /*
        LeetCode (46/150)
        https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: nums = [1,2,3,1], k = 3
        Output: true

        Example 2:
        Input: nums = [1,0,1,1], k = 1
        Output: true

        Example 3:
        Input: nums = [1,2,3,1,2,3], k = 2
        Output: false
    */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // number -> index
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (map.containsKey(key) && i - map.get(key) <= k) {
                return true;
            } 
            map.put(key, i);
        }
        return false;
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

        boolean ans = new ContainsDuplicateII().containsNearbyDuplicate(nums, k);
        System.out.println(ans);
    }
}
