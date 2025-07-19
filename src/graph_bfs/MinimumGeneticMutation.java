package graph_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MinimumGeneticMutation {
    /*
        LeetCode (96/150)
        https://leetcode.com/problems/minimum-genetic-mutation/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(4*n)
        Auxiliary Space : O(n)
        
        Example 1:
        Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
        Output: 1

        Example 2:
        Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
        Output: 2
    */

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));

        // if bank doesn't have end gene, its not valid
        if (!geneBank.contains(endGene)) {
            return -1;
        }

        // options for a mutation
        char[] options = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);
        int mutations = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            // mutate all genes from current level
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                // return if end mutation is reached
                if (curr.equals(endGene)) {
                    return mutations;
                }
                                
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char org = arr[j];

                    // generate all possible mutations
                    for (char ch : options) {
                        if (arr[j] == ch) {
                            continue;
                        }
                        arr[j] = ch;
                        String mutated = new String(arr);

                        // check if the bank has this mutation
                        if (geneBank.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            q.offer(mutated);
                        }
                    }

                    // restore the original gene (backtrack)
                    arr[j] = org;
                }
            }
            mutations++;
        }

        // no mutations were possible
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start = sc.nextLine();
        String end = sc.nextLine();
        String[] bank = sc.nextLine().split(" ");
        sc.close();

        int ans = new MinimumGeneticMutation().minMutation(start, end, bank);
        System.out.println(ans);
    }
}
