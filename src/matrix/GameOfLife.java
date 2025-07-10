package matrix;

import java.util.Scanner;

public class GameOfLife {
    /*
        LeetCode (38/150)
        https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n*m)
        Auxiliary Space : O(1)

        Example 1:
        Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

        Example 2:
        Input: board = [[1,1],[1,0]]
        Output: [[1,1],[1,1]]
    */

    // all possible neighbours
    private final static int[][] DIRECTIONS = {
        {-1, -1}, {-1,  0}, {-1,  1}, {0, -1},
        { 0,  1}, { 1, -1}, { 1,  0}, {1,  1}
    };

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // count alive neighbours
                int lives = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + DIRECTIONS[k][0];
                    int y = j + DIRECTIONS[k][1];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    // increment count if alive
                    lives += board[x][y] & 1;
                }
                
                // set the 2nd LSB for those who will be alive in the next state
                if (
                    (board[i][j] & 1) == 1 && (lives == 2 || lives == 3)
                ||
                    (board[i][j] & 1) == 0 && lives == 3
                ) {
                    board[i][j] |= 2; 
                } 
            }
        }

        // move 2nd LSB to the LSB
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        new GameOfLife().gameOfLife(matrix);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
