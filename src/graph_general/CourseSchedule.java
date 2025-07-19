package graph_general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseSchedule {
    /*
        LeetCode (93/150)
        https://leetcode.com/problems/course-schedule/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m + n)
        Auxiliary Space : O(m + n)

        * m = no. of nodes, n = no. of edges

        Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: true
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0. So it is possible.

        Example 2:
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false
        Explanation: There are a total of 2 courses to take. 
        To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
    */
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // all courses can be taken if there is no cyclic prerequisite dependencies
        // KAHN'S ALGORITHM to detect cycle
        // can be used for Topological sort also

        // inDegree[i] = no. of incoming edges into node i
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            inDegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }

        int coursesTaken = 0;
        Queue<Integer> q = new LinkedList<>();

        // add all the nodes with 0 indegree
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            // remove each node in queue (take the course) and
            // reduce the indegree of all destination nodes by 1
            int course = q.poll();
            coursesTaken++;

            for (int next : adj.get(course)) {
                inDegree[next]--;
                // if inDegree of any node becomes 0, add it to queue
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // there is no cycle if all nodes/courses are successfully removed/taken
        return coursesTaken == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        sc.close();

        boolean ans = new CourseSchedule().canFinish(n, nums);
        System.out.println(ans);
    }
}