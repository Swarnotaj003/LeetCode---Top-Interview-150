package array_or_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpGameI {
    /*
        Leetcode (9/150)
        https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Example 2:
        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
    */  

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (i > pos) {
                return false;
            }
            pos = Math.max(pos, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        BufferedReader br;
        int n, nums[] = new int[0];

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
            }
            br.close();
        } catch (NumberFormatException | IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        
        boolean ans = new JumpGameI().canJump(nums);
        System.out.println(ans);
    }
}
