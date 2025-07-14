package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedListII {
    /*
        LeetCode (64/150)
        https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [1,2,3,3,4,4,5]
        Output: [1,2,5]

        Example 2:
        Input: head = [1,1,1,2,3]
        Output: [2,3]
    */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums.add(Integer.parseInt(num));
        }
        sc.close();

        // create the linked list
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int num : nums) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        head = head.next;

        ListNode ans = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
