package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseLinkedListII {
    /*
        LeetCode (61/150)
        https://leetcode.com/problems/reverse-linked-list-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [1,2,3,4,5], left = 2, right = 4
        Output: [1,4,3,2,5]

        Example 2:
        Input: head = [5], left = 1, right = 1
        Output: [5]
    */

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left >= right) {
            return head;
        }

        ListNode newList = new ListNode(0);
        newList.next = head;
        ListNode prev = newList;

        // point to the node before left
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // reverse the sublist [left, right]
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return newList.next;   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        sc.close();

        // create linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new ReverseLinkedListII().reverseBetween(head, left, right);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }        
        System.out.println();
    }
}
