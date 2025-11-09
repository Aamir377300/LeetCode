
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

        /*
        VISUALIZATION OF THE RECURSION
        --------------------------------

        Example list:
        1 -> 2 -> 3 -> 4 -> 5 -> null

        CALL STACK (going DOWN)
        reverseList(1)
           reverseList(2)
              reverseList(3)
                 reverseList(4)
                    reverseList(5)
                       reverseList(null) -> return null

        UNWINDING (coming UP)

        Returning from reverseList(5):
            newHead = 5 // as 5 is alone so directly it is linked list so its next become null
            List: 5 -> null

        Returning from reverseList(4):
            4.next.next = 4   (5 -> 4){ys moment pr 4 ka next tha 5}
            4.next = null
            List: 5 -> 4 -> null

        Returning from reverseList(3):
            3.next.next = 3   (4 -> 3)
            3.next = null
            List: 5 -> 4 -> 3 -> null

        Returning from reverseList(2):
            2.next.next = 2   (3 -> 2)
            2.next = null
            List: 5 -> 4 -> 3 -> 2 -> null

        Returning from reverseList(1):
            1.next.next = 1   (2 -> 1)
            1.next = null
            FINAL LIST:
            5 -> 4 -> 3 -> 2 -> 1 -> null
        */

        // BASE CASE
        if (head == null || head.next == null)
            return head;

        // RECURSIVE CALL
        ListNode newHead = reverseList(head.next);

        // REVERSE THE POINTER
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}