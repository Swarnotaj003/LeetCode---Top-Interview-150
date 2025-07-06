package array_or_string;

import java.util.Scanner;

public class GasStation {
    /*
        Leetcode (14/150)
        https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example:
        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3
        Explanation:
        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 4. Your tank = 4 - 1 + 5 = 8
        Travel to station 0. Your tank = 8 - 2 + 1 = 7
        Travel to station 1. Your tank = 7 - 3 + 2 = 6
        Travel to station 2. Your tank = 6 - 4 + 3 = 5
        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        Therefore, return 3 as the starting index.
    */ 

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int start = 0;
        int gasTank = 0;

        for (int i = 0; i < n; i++) {
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                gasTank = 0;
                start = i+1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] gas = new int[n];
        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        sc.close();

        int ans = new GasStation().canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }
}
