package linked_list;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node 
// with random pointer
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    /*
        LeetCode (60/150)
        https://leetcode.com/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-interview-150

        Time Complexity : O(n)
        Auxiliary Space : O(n)

        NOTE: The purpose is create a deep copy of the list

        Example 1:
        Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Example 2:
        Input: head = [[1,1],[2,1]]
        Output: [[1,1],[2,1]]

        Example 3:
        Input: head = [[3,null],[3,0],[3,null]]
        Output: [[3,null],[3,0],[3,null]]
    */

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
  
        // original node -> deep copy
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        // assign next and random pointers
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        
        return map.get(head);
    }

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);

        node.next.random = node;                            // 13->7
        node.next.next.random = node.next.next.next.next;   // 11->1
        node.next.next.next.random = node.next.next;        // 10->11
        node.next.next.next.next.random = node;             // 1->7

        Node deepCopy = new CopyListWithRandomPointer().copyRandomList(node);
        while (deepCopy != null) {
            System.out.print("(" + deepCopy.val + ", " + (deepCopy.random == null ? "null" : deepCopy.random.val) + ") -> ");
            deepCopy = deepCopy.next;
        }
        System.out.println();
    }
}
