package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTwoNumbers {
    /*
        LeetCode (58/150)
        https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(max(m, n))
        Auxiliary Space : O(1)

        NOTE: The sum will be too large to be accomodated within int or long

        Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.

        Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]

        Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode();
        ListNode temp = sumList;
        int digit = 0, carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            digit = n1 + n2 + carry;
            temp.next = new ListNode(digit % 10);
            temp = temp.next;

            carry = digit / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return sumList.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums1 = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (String num : input) {
            nums1.add(Integer.parseInt(num));
        }
        
        List<Integer> nums2 = new ArrayList<>();
        input = sc.nextLine().split(" ");
        for (String num : input) {
            nums2.add(Integer.parseInt(num));
        }
        sc.close();

        // create linked lists
        ListNode l1 = new ListNode();
        ListNode temp = l1;
        for (int num : nums1) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        l1 = l1.next;

        ListNode l2 = new ListNode();
        temp = l2;
        for (int num : nums2) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        l2 = l2.next;
        
        ListNode ans = new AddTwoNumbers().addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
