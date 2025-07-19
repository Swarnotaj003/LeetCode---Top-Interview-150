package graph_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class WordLadder {
    /*
        LeetCode (97/150)
        https://leetcode.com/problems/word-ladder/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(26*m*n)
        Auxiliary Space : O(m*n)
        
        Example 1:
        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        Output: 5
        Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

        Example 2:
        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
        Output: 0
        Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
    */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);

        // if dictionary doesn't have end word, its not valid
        if (!dictionary.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            // transform all words from current level
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                // return if end word is reached
                if (curr.equals(endWord)) {
                    return steps + 1;
                }

                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char org = arr[j];

                    // generate all possible transformations
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;
                        String next = new String(arr);
                        
                        // check if the dictionary has this word
                        if (dictionary.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    // restore the original word (backtrack)
                    arr[j] = org;
                }
            }
            steps++;
        }

        // no transformations were possible
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();
        String[] bank = sc.nextLine().split(" ");
        sc.close();

        int ans = new WordLadder().ladderLength(start, end, Arrays.asList(bank));
        System.out.println(ans);
    }
}
