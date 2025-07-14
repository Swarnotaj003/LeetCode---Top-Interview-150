package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveNthNodeFromEndOfList {
    /*
        LeetCode (63/150)
        https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]

        Example 2:
        Input: head = [1], n = 1
        Output: []
    */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // if n is equal to the length of the list
        // fast will ne null, then remove the head
        if (fast == null) {
            return head.next;
        }

        // when fast points to last node
        // slow will point to (n+1)th last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove the nth last node
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        int n = sc.nextInt();
        sc.close();

        // create the linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
