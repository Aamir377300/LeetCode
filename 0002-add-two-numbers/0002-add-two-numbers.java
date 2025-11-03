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

 // as the sum is added in reverse order so as per the question say about the added in reverse we take as advantage
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead_Value = new ListNode(0);

        ListNode l3 = dummyHead_Value;



        int carry =0;

        while(l1 != null || l2 != null || carry !=0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum/10;

// in the modolo if the divisor is greater than dividient then the remainder be its divdient
            int digit = sum %10;
            
            l3.next = new ListNode(digit);
            l3= l3.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummyHead_Value.next;
    }
}