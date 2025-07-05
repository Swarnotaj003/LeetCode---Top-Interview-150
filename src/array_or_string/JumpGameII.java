package array_or_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpGameII {
    /*
        Leetcode (10/150)
        https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        
        Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2
    */ 

    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int currEnd = 0, maxEnd = 0;

        for (int i = 0; i < n-1; i++) {
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = maxEnd;
                if (currEnd >= n-1) {
                    break;
                }
            }
        }

        return jumps;
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
        
        int ans = new JumpGameII().jump(nums);
        System.out.println(ans);
    }
}
