package graph_general;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {
    /*
        LeetCode (89/150)
        https://leetcode.com/problems/number-of-islands/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m * n)
        Auxiliary Space : O(m * n)

        Example 1:
        Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
        ]
        Output: 1

        Example 2:
        Input: grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
        ]
        Output: 3
    */

    // LEFT, TOP, RIGHT, BOTTOM
    private final static int[][] DIRECTIONS = {
        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // if an unvisited land is encountered increment count
                // & explore the whole island (mark visited)
                if (grid[i][j] == '1') {
                    islands++;
                    exploreIslandBFS(grid, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    // BFS method
    private void exploreIslandBFS(char[][] grid, int i, int j, int rows, int cols) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        
        // mark visited
        grid[i][j] = '#';

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            // explore all neighbours
            for (int[] dir : DIRECTIONS) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                    q.offer(new int[] {x, y});
                    grid[x][y] = '#';
                }
            }
        }
    }

    // DFS method
    private void exploreIslandDFS(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }

        // mark visited
        grid[i][j] = '#';

        // explore all directions
        exploreIslandDFS(grid, i-1, j, rows, cols);
        exploreIslandDFS(grid, i, j-1, rows, cols);
        exploreIslandDFS(grid, i+1, j, rows, cols);
        exploreIslandDFS(grid, i, j+1, rows, cols);
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

        int ans = new NumberOfIslands().numIslands(grid);
        System.out.println(ans);
    }
}
