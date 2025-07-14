package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateList {
    /*
        LeetCode (65/150)
        https://leetcode.com/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]

        Example 2:
        Input: head = [0,1,2], k = 4
        Output: [2,0,1]
    */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }
        
        ListNode curr = head;
        for (int i = 0; i < length-k-1; i++) {
            curr = curr.next;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
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

        // create the linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new RotateList().rotateRight(head, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
