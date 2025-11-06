/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//  https://www.youtube.com/watch?v=ZOoSl72MBfY

// Floyd's Tortoise and Hare Algorithm

// in this algorithm the slow run by 1 km then the fast run throgh the 2km

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            

            if(fast != null && fast.equals(slow)){
                return true;
            }
        } 
            return false;
    }
}