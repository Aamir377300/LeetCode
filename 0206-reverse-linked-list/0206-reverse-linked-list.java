
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.*;


// stack
// class Solution {
//     public ListNode reverseList(ListNode head) {

//         if (head == null) {
//             return null;
//         }

//         Stack<Integer> st = new Stack<>();
//         ListNode temp = head;

//         while (temp != null) {
//             st.push(temp.val);
//             temp = temp.next;
//         }

//         // again change temp to head
//         temp = head;
//         while (!st.isEmpty()) {
//             temp.val = st.pop();
//             temp = temp.next;

//         }

//         return head;
//     }
// }

// two pointer
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev = null;
//         ListNode curr = head;
        
//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
        
//         return prev;
//     }
// }

// recurrsion
class Solution {
    public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
        return head;



    ListNode newHead = reverseList(head.next);

    head.next.next = head;
    head.next = null;

    return newHead;
    }
}