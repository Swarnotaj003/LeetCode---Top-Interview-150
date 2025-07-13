package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeTwoSortedLists {
    /*
        LeetCode (59/150)
        https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(m + n)
        Auxiliary Space : O(1)

        Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

        Example 2:
        Input: list1 = [], list2 = []
        Output: []

        Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]
    */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode temp = merged;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        
        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return merged.next;
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
        
        ListNode ans = new MergeTwoSortedLists().mergeTwoLists(l1, l2);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
