package graph_general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseScheduleII {
    /*
        LeetCode (94/150)
        https://leetcode.com/problems/course-schedule-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m + n)
        Auxiliary Space : O(m + n)

        * m = no. of nodes, n = no. of edges

        Example 1:
        Input: numCourses = 2, prerequisites = [[1,0]]
        Output: [0,1]
        Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

        Example 2:
        Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        Output: [0,2,1,3]
        Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

        Example 3:
        Input: numCourses = 1, prerequisites = []
        Output: [0]
    */
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // courses can be taken any order of topological sort
        // KAHN'S ALGORITHM
        
        // the order is generated in reverse order
        // (a, b) ->  b must be taken before a
        int[] order = new int[numCourses];
        int index = numCourses - 1;

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
            order[index--] = course;

            for (int next : adj.get(course)) {
                inDegree[next]--;
                // if inDegree of any node becomes 0, add it to queue
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // return the order if there is no cycle
        // i.e. all courses are taken (removed)
        return coursesTaken == numCourses ? order : new int[0];
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

        int[] ans = new CourseScheduleII().findOrder(n, nums);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
