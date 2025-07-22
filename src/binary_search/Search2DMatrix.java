package binary_search;

import java.util.Scanner;

public class Search2DMatrix {
    /*
        LeetCode (115/150)
        https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(log m + log n)
        Auxiliary Space : O(1)

        Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true

        Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        sc.close();

        boolean ans = new Search2DMatrix().searchMatrix(matrix, target);
        System.out.println(ans);
    }
}
