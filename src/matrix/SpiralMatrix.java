package matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    /*
        LeetCode (35/150)
        https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(1)

        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

        Example 2:
        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    */

    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int x = 0, y = 0;
        int dx = 1, dy = 0;
        List<Integer> spiral = new ArrayList<>();

        for (int i = 0; i < rows * cols; i++) {
            spiral.add(matrix[y][x]);
            // mark as visited
            matrix[y][x] = -999; 
            if (
                // if boundary is exceeded
                !(x + dx >= 0 && x + dx < cols && y + dy >= 0 && y + dy < rows) 
            || 
                // or a visited element is encountered
                matrix[y + dy][x + dx] == -999
            ) {
                // switch directions
                int temp = dx;
                dx = -dy;
                dy = temp;
            }
            x += dx;
            y += dy;
        }
        return spiral;
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

        List<Integer> list = new SpiralMatrix().spiralOrder(matrix);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
