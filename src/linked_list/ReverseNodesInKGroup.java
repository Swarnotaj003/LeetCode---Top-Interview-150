package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseNodesInKGroup {
    /*
        LeetCode (62/150)
        https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n/k)

        Example 1:
        Input: head = [1,2,3,4,5], k = 2
        Output: [2,1,4,3,5]

        Example 2:
        Input: head = [1,2,3,4,5], k = 3
        Output: [3,2,1,4,5]
    */

    public ListNode reverseKGroup(ListNode head, int k) {
        // point to the tail of k-group
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        // assign reversed k-group as the new head
        ListNode newHead = reverseNodes(head, tail);

        // next of old head will contain the tail with k-group reversals
        head.next = reverseKGroup(tail, k);
        
        return newHead;
    }

    private ListNode reverseNodes(ListNode head, ListNode tail) {
        ListNode curr = head, prev = null;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        int k = sc.nextInt();
        sc.close();

        // create linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new ReverseNodesInKGroup().reverseKGroup(head, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }        
        System.out.println();
    }
}
