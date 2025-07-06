package array_or_string;

import java.util.Arrays;
import java.util.Scanner;

public class Candy {
    /*
        Leetcode (15/150)
        https://leetcode.com/problems/candy/submissions/1688209384/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        Example 1:
        Input: ratings = [1,0,2]
        Output: 5
        Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

        Example 2:
        Input: ratings = [1,2,2]
        Output: 4
        Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
        The third child gets 1 candy because it satisfies the above two conditions.
    */ 

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }

        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        sc.close();

        int ans = new Candy().candy(nums);
        System.out.println(ans);
    }
}
