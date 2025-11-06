// Floyd's Tortoise and Hare Algorithm

// in this the we take the slow and fast pointer and then in this the fast move as the n value then move 1 time each

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i =0; i<n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next; // the slow move 1 position after the above things
            fast = fast.next; // the fast move 1 position similar 
        }

        slow.next = slow.next.next;

        return head;
    }
}