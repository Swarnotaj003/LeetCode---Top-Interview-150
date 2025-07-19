package graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EvaluateDivision {
    /*
        LeetCode (92/150)
        https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n + q*(m + n))
        Auxiliary Space : O(m + n)

        * m = no. of unique nodes/operands, n = no. of edges, q = no. of queries

        Example 1:
        Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        Explanation: 
        Given: a / b = 2.0, b / c = 3.0, queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
        return: [6.0, 0.5, -1.0, 1.0, -1.0 ], note: x is undefined => -1.0

        Example 2:
        Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
        Output: [3.75000,0.40000,5.00000,0.20000]
    */

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries
    ) {
        // start (a) -> (end (b), weight (a/b))
        Map<String, Map<String, Double>> adjList = new HashMap<>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double value = values[i];

            // Put a -> (b, a/b = n)
            adjList.putIfAbsent(start, new HashMap<>());
            adjList.get(start).put(end, value);
            
            // Put b -> (a, b/a = 1/n)
            adjList.putIfAbsent(end, new HashMap<>());
            adjList.get(end).put(start, 1.0 / value);
        }

        int q = queries.size();
        double[] results = new double[q];

        for (int i = 0; i < q; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            // if the graph doesn't contain any of the operands
            // don't evaluate
            if (!adjList.containsKey(a) || !adjList.containsKey(b)) {
                results[i] = -1.0;
            } 
            // else the ans is product of path weights from a to b
            // e.g. a path a->c->d->b implies a/b = a/c * c/d * d/b
            else {
                results[i] = dfs(adjList, new HashSet<>(), a, b, 1.0);
            }            
        }
        return results;
    }

    private double dfs(
        Map<String, Map<String, Double>> graph, Set<String> visited, String a, String b, double value
    ) {
        // return the accumulated value
        if (a.equals(b)) {
            return value;
        }
        
        visited.add(a);

        // explore a's unvisited neighbours to reach b
        for (Map.Entry<String, Double> entry : graph.get(a).entrySet()) {
            String c = entry.getKey();

            if (!visited.contains(c)) {
                double res = dfs(graph, visited, c, b, value * entry.getValue());
                // found a valid path
                if (res > 0) {
                    return res;
                }
            }
        }
        
        // no valid path found
        return -1.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<List<String>> equations = new ArrayList<>();
        double[] values = new double[n];

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            list.add(input[0]);
            list.add(input[1]);
            equations.add(list);
            values[i] = Double.parseDouble(input[2]);
        }
        
        int q = sc.nextInt();
        sc.nextLine();
        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] input = sc.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            list.add(input[0]);
            list.add(input[1]);
            queries.add(list);
        }
        sc.close();

        double[] results = new EvaluateDivision().calcEquation(equations, values, queries);
        for (double d : results) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
