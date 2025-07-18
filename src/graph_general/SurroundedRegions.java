package graph_general;

import java.util.Scanner;

public class SurroundedRegions {
    /*
        LeetCode (90/150)
        https://leetcode.com/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m * n)
        Auxiliary Space : O(m * n)

        Example 1:
        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        Explanation:
        In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

        Example 2:
        Input: board = [["X"]]
        Output: [["X"]]
    */

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // if a region is present in first or last column
        // save its adjacent regions ('O' cells)
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                saveAdjacentRegions(board, i, 0, rows, cols);
            }
            if (board[i][cols-1] == 'O') {
                saveAdjacentRegions(board, i, cols-1, rows, cols);
            }
        }

        // if a region is present in first or last row
        // save its adjacent regions ('O' cells)
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                saveAdjacentRegions(board, 0, j, rows, cols);
            }
            if (board[rows-1][j] == 'O') {
                saveAdjacentRegions(board, rows-1, j, rows, cols);
            }
        }

        // capture the unsaved regions (rename 'O' to 'X')
        // declare the saved regions (rename 'S' to 'O')
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void saveAdjacentRegions(char[][] board, int i, int j, int rows, int cols) {
        // exit if boundary exceeded or region not found
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
            return;
        }

        // save the current region
        board[i][j] = 'S';

        // explore all directions
        saveAdjacentRegions(board, i-1, j, rows, cols);
        saveAdjacentRegions(board, i, j-1, rows, cols);
        saveAdjacentRegions(board, i+1, j, rows, cols);
        saveAdjacentRegions(board, i, j+1, rows, cols);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        System.out.println();

        new SurroundedRegions().solve(grid);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
