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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // a dummy node is created such as a list is created (a list is also made which is use for the use ListNode but it is very lengthy and complex)

        ListNode dummy = new ListNode(-1); // if i just write ListNode dummy then dummy is be null and in code i have null.next = list1(give null pointer exception), so first i have intialize it for memory allocations
        ListNode temp = dummy; // head is now temp 


        while(list1 != null && list2 != null){
            // sorted order me chaiye
            if(list1.val <= list2.val){
                // -1 -> 1 -> 1 -> .....
                temp.next = list1;
                list1 = list1.next; // tranverse the list1
            }
            else{
                temp.next = list2;
                list2 = list2.next; // tranverse the list2
            }

            temp = temp.next;     
        }

        if(list1 == null){
            temp.next = list2;
        }
        else{
            temp.next = list1;
        }
        return dummy.next; // dummy is intialize as the -1 so its next should be the head
    }
}