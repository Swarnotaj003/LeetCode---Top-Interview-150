package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkedListCycle {
    /*
        LeetCode (57/150)
        https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [3,2,0,-4], pos = 1
        Output: true
        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

        Example 2:
        Input: head = [1,2], pos = -1
        Output: false
        Explanation: There is no cycle in the linked list.
    */

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        int pos = sc.nextInt();
        sc.close();

        // create linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        // insert cycle
        if (pos >= 0) {
            pos %= nums.size();
            ListNode cycleTo = head, cycleFrom = head;
            for (int i = 0; i < pos; i++) {
                cycleTo = cycleTo.next;
            }
            while (cycleFrom.next != null) {
                cycleFrom = cycleFrom.next;
            }
            cycleFrom.next = cycleTo;
        }

        boolean ans = new LinkedListCycle().hasCycle(head);
        System.out.println(ans);
    }
}
