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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        List <ListNode> lt = new LinkedList<>();

        ListNode temp = head;

        while(temp != null){
            lt.add(temp);
            temp = temp.next;
        }


        int n = lt.size();
        int mid=n/2;
        
        if (mid == 0) return head.next;
        
        ListNode prev = lt.get(mid-1);

        prev.next = prev.next.next;

        return head;
        


         
    }
}