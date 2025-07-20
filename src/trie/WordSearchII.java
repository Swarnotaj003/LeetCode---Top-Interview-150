package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearchII {
    /*
        LeetCode (100/150)
        https://leetcode.com/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m*n*4^m)
        Auxiliary Space : O(m*n)

        Example 1:
        Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
        Output: ["eat","oath"]

        Example 2:
        Input: board = [["a","b"],["c","d"]], words = ["abcb"]
        Output: []
    */
    
    // this time we store the entire word (path) in a node
    // to avoid extra space usage during traversal
    private class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        List<String> found = new ArrayList<>();
        TrieNode root = buildTrie(words);

        // traverse the board from all positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, found);
            }
        }
        return found;
    }

    // build the trie using all the words
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> list) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        // return if already visited or prefix not present
        char ch = board[i][j];
        if (ch == '#' || root.children[ch - 'a'] == null) {
            return;
        }

        // found a word
        root = root.children[ch - 'a'];
        if (root.word != null) {
            list.add(root.word);
            root.word = null;   // to avoid duplicate entries
        }

        // mark as visited
        board[i][j] = '#';

        // explore all nearby characters in the board
        dfs(board, i-1, j, root, list);
        dfs(board, i, j-1, root, list);
        dfs(board, i+1, j, root, list);
        dfs(board, i, j+1, root, list);

        // unmark & restore (backtrack)
        board[i][j] = ch;
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

        String[] words = sc.nextLine().split(" ");
        sc.close();

        List<String> ans = new WordSearchII().findWords(board, words);
        for (String s : ans) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
