package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IPO {
    /*
        LeetCode (122/150)
        https://leetcode.com/problems/ipo/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log n + k log n)
        Auxiliary Space : O(n)

        Example 1:
        Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
        Output: 4
        Explanation: Since your initial capital is 0, you can only start the project indexed 0.
        After finishing it you will obtain profit 1 and your capital becomes 1.
        With capital 1, you can either start the project indexed 1 or the project indexed 2.
        Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
        Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.

        Example 2:
        Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
        Output: 6
    */

    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }
        // sort projects by increasing order of capital
        Collections.sort(projects, (a, b) -> a.capital - b.capital);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        for (int j = 0; j < k; j++) {
            // add all the affordable projects to max heap
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }
            // no project available
            if (maxHeap.isEmpty()) {
                break;
            }
            // take the project with max profit
            w += maxHeap.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] capital = new int[n];
        for (int i = 0; i < n; i++) {
            capital[i] = sc.nextInt();
        }
        int[] profits = new int[n];
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int w = sc.nextInt();
        sc.close();

        int ans = new IPO().findMaximizedCapital(k, w, profits, capital);
        System.out.println(ans);
    }
}
