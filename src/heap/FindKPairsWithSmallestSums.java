package heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class FindKPairsWithSmallestSums {
    /*
        LeetCode (123/150)
        https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(k log k)
        Auxiliary Space : O(k)

        Example 1:
        Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        Output: [[1,2],[1,4],[1,6]]
        Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        Example 2:
        Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
        Output: [[1,1],[1,1]]
        Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
    */

    private static class Pair<K, V> {
        K key;
        V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> pairs = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // add the smallest pair
        minHeap.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];
            pairs.add(List.of(nums1[i], nums2[j]));

            // next smallest pair will be one of the two pairs
            // by incrementing each pointer at a time
            if (i < m-1 && !visited.contains(new Pair<>(i + 1, j))) {
                minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair<>(i + 1, j));
            }
            if (j < n-1 && !visited.contains(new Pair<>(i, j + 1))) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair<>(i, j + 1));
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        sc.close();

        List<List<Integer>> ans = new FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, k);
        for (List<Integer> l : ans) {
            System.out.print("(" + l.get(0) + ", " + l.get(1)+ "), ");
        }
        System.out.println();
    }
}
