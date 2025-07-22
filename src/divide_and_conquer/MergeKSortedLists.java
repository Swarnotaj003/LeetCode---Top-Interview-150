package divide_and_conquer;

import java.util.Scanner;

import linked_list.ListNode;

public class MergeKSortedLists {
    /*
        LeetCode (111/150)
        https://leetcode.com/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n log k)
        Auxiliary Space : O(log k)

        Example 1:
        Input: lists = [[1,4,5],[1,3,4],[2,6]]
        Output: [1,1,2,3,4,4,5,6]
        Explanation: The linked-lists are:
        [ 1->4->5, 1->3->4, 2->6 ]
        merging them into one sorted linked list:
        1->1->2->3->4->4->5->6

        Example 2:
        Input: lists = []
        Output: []

        Example 3:
        Input: lists = [[]]
        Output: []
    */

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return lists[low];
        }

        int mid = (low + high)/2;
        ListNode left = mergeLists(lists, low, mid);
        ListNode right = mergeLists(lists, mid + 1, high);
        return mergeTwoSortedLists(left, right);
    }

    private ListNode mergeTwoSortedLists(ListNode left, ListNode right) {
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
        int k = sc.nextInt();
        sc.nextLine();
        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            String[] input = sc.nextLine().split(" ");
            ListNode head = new ListNode();
            ListNode temp = head;
            for (String num : input) {
                temp.next = new ListNode(Integer.parseInt(num));
                temp = temp.next;
            }
            lists[i] = head.next;
        }
        sc.close();

        ListNode ans = new MergeKSortedLists().mergeKLists(lists);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
