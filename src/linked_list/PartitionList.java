package linked_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionList {
    /*
        LeetCode (66/150)
        https://leetcode.com/problems/partition-list/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(1)

        Example 1:
        Input: head = [1,4,3,2,5,2], x = 3
        Output: [1,2,2,4,3,5]

        Example 2:
        Input: head = [2,1], x = 2
        Output: [1,2]
    */

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode temp1 = left, temp2 = right;

        while (head != null) {
            if (head.val < x) {
                temp1.next = head;
                temp1 = temp1.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
            }
            head = head.next;
        }

        // disconnect the tail of right 
        temp2.next = null;

        // connect the tail of left to right
        temp1.next = right.next;

        // remove the dummy start nodes
        right.next = null;
        return left.next;
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

        ListNode ans = new PartitionList().partition(head, k);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
        System.out.println();
    }
}
