package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams {
    /*
        LeetCode (43/150)
        https://leetcode.com/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n*m log m)
        Auxiliary Space : O(n + m)

        Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        Explanation:
        There is no string in strs that can be rearranged to form "bat".
        The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
        The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

        Example 2:
        Input: strs = [""]
        Output: [[""]]

        Example 3:
        Input: strs = ["a"]
        Output: [["a"]]
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        // sorted sequence of chars -> all possible anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = String.valueOf(arr);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(s);
            map.put(key, anagrams);
        }
        
        List<List<String>> groups = new ArrayList<>();
        for (List<String> anagrams : map.values()) {
            groups.add(anagrams);
        }
        return groups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            strs[i] = input[i];
        }
        sc.close();

        List<List<String>> groups = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> anagrams : groups) {
            for (String anagram : anagrams) {
                System.out.print(anagram + " ");
            }
            System.out.println();
        }
    }
}