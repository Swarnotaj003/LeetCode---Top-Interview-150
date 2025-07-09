package matrix;

import java.util.Scanner;

public class ValidSudoku {
    /*
        LeetCode (34/150)
        https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n^2)
        Auxiliary Space : O(n)

        Example 1:
        Input: board = 
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: true

        Example 2:
        Input: board = 
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: false
        Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. 
        Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    */

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // create 3 flag arrays, each for rows, columns & sub-boxes
        // the 'i'th least bit indicate whether i was used or not 
        int[] rows = new int[n];
        int[] columns = new int[n];
        int[] boxes = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int mask = 1 << num;
                int boxId = (i/3)*3 + j/3;

                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxId] & mask) != 0) {
                    return false;
                }
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxId] |= mask; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] row = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = row[j];
            }
        }
        sc.close();

        boolean ans = new ValidSudoku().isValidSudoku(board);
        System.out.println(ans);
    }
}
