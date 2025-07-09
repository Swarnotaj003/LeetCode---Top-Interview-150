package matrix;

import java.util.Scanner;

public class RotateImage {
    /*
        LeetCode (36/150)
        https://leetcode.com/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(1)

        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]

        Example 2:
        Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    */

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // get transpose of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    
        // reverse the columns
        int left = 0, right = n-1;
        while (left < right) {
            int[] tempCol = new int[n];
            for (int i = 0; i < n; i++) {
                tempCol[i] = matrix[i][left];
            }
            for (int i = 0; i < n; i++) {
                matrix[i][left] = matrix[i][right];
            }
            for (int i = 0; i < n; i++) {
                matrix[i][right] = tempCol[i];
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        new RotateImage().rotate(matrix);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
