package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SubstringWithConcatenationOfAllWords {
    /*
        LeetCode (32/150)
        https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n*w)
        Auxiliary Space : O(n)

        Example 1:
        Input: s = "barfoothefoobarman", words = ["foo","bar"]
        Output: [0,9]
        Explanation:
        The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
        The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

        Example 2:
        Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
        Output: []
        Explanation:
        There is no concatenated substring.

        Example 3:
        Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
        Output: [6,9,12]
        Explanation:
        The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
        The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
        The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
    */

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wordSize = words[0].length();
        int wordCount = words.length;
        List<Integer> indices = new ArrayList<>();

        HashMap<String, Integer> originalCount = new HashMap<>();
        for (int i = 0; i < wordCount; i++) {
            originalCount.put(words[i], originalCount.getOrDefault(words[i], 0) + 1);
        }

        for (int offset = 0; offset < wordSize; offset++) {
            HashMap<String, Integer> currentCount = new HashMap<>();
            int left = offset;
            int count = 0;
            for (int right = offset; right + wordSize <= n; right += wordSize) {
                String currWord = s.substring(right, right + wordSize);
                if (originalCount.containsKey(currWord)) {
                    currentCount.put(currWord, currentCount.getOrDefault(currWord, 0) + 1);
                    count++;

                    while (currentCount.get(currWord) > originalCount.get(currWord)) {
                        String startWord = s.substring(left, left + wordSize);
                        currentCount.put(startWord, currentCount.get(startWord) - 1);
                        left += wordSize;
                        count--;                        
                    }

                    if (count == wordCount) {
                        indices.add(left);
                    }
                }
                else {
                    count = 0;
                    left = right + wordSize;
                    currentCount.clear();
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        String[] words = new String[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            words[i] = input[i];
        }
        sc.close();

        List<Integer> ans = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
