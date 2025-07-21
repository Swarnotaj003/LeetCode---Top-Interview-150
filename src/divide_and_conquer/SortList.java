package divide_and_conquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import linked_list.ListNode;

public class SortList {
    /*
        LeetCode (109/150)
        https://leetcode.com/problems/sort-list/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log n)
        Auxiliary Space : O(log n)

        Example 1:
        Input: head = [4,2,1,3]
        Output: [1,2,3,4]

        Example 2:
        Input: head = [-1,5,3,4,0]
        Output: [-1,0,3,4,5]
    */

    public ListNode sortList(ListNode head) {
        return mergeSortList(head);
    }

    private ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head, temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
        return mergeLists(left, right);
    }

    private ListNode mergeLists(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        sc.close();

        // create linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new SortList().sortList(head);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
