package backtracking;

import java.util.Scanner;

public class WordSearch {
    /*
        LeetCode (107/150)
        https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n*4^k)
        Auxiliary Space : O(k)

        Example 1:
        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        Output: true

        Example 2:
        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        Output: true

        Example 3:
        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
        Output: false
    */

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // start searching from all points one by one
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int i, int j, int k, String word) {
        // word search successful
        if (k == word.length()) {
            return true;
        }

        // exceeded boundary or different character found
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(k) != board[i][j]){
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '#';  // mark as visited

        // explore all directions
        boolean found = searchWord(board, i-1, j, k+1, word)
            || searchWord(board, i, j-1, k+1, word)
            || searchWord(board, i+1, j, k+1, word)
            || searchWord(board, i, j+1, k+1, word);

        board[i][j] = ch;   // unmark & backtrack
        return found;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        sc.nextLine();

        String word = sc.nextLine();
        sc.close();

        boolean ans = new WordSearch().exist(board, word);
        System.out.println(ans);
    }
}
