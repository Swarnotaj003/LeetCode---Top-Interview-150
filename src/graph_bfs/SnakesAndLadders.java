package graph_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadders {
    /*
        LeetCode (95/150)
        https://leetcode.com/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n^2)

        Example 1:
        Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
        Output: 4
        Explanation: 
        In the beginning, you start at square 1 (at row 5, column 0).
        You decide to move to square 2 and must take the ladder to square 15.
        You then decide to move to square 17 and must take the snake to square 13.
        You then decide to move to square 14 and must take the ladder to square 35.
        You then decide to move to square 36, ending the game.
        This is the lowest possible number of moves to reach the last square, so return 4.

        Example 2:
        Input: board = [[-1,-1],[-1,3]]
        Output: 1
    */

    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // minRolls[i] = min. no. of dice rolls to reach i
        int[] minRolls = new int[n*n + 1];
        Arrays.fill(minRolls, -1);
        minRolls[1] = 0;

        // start at 1
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (!q.isEmpty()) {
            int curr = q.poll();

            // from current position we can go ahead by 1 to 6 steps
            for (int i = 1; i <= 6 && curr + i <= n*n; i++) {
                int next = curr + i;
                int row = (next - 1) / n;
                int col = (next - 1) % n;

                // positions on snakes & ladders board are arranged in "Boustrophedon style" 
                int val = board[n - 1 - row][(row % 2 == 1) ? (n - 1 - col) : col];

                // we have to take the snake or ladder if any
                next = (val != -1) ? val : next;

                // return one more of min. rolls to reach curr, if next is n^2
                if (next == n*n) {
                    return minRolls[curr] + 1;
                }

                // update min. rolls to reach next & add to queue
                if (minRolls[next] == -1) {
                    minRolls[next] = minRolls[curr] + 1;
                    q.offer(next);
                }
            }
        }

        // reaching the end is not possible
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int ans = new SnakesAndLadders().snakesAndLadders(nums);
        System.out.println(ans);
    }
}
