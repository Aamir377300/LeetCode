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

 // Approach: We make a list in which we store the whole linked list then we make two pointer and one start from 0 and other l1.size()-1 and if they are equals then return true otherwise false;
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList <Integer> l = new ArrayList<>();


        ListNode temp = head;

        while(temp != null){
            l.add(temp.val);
            temp = temp.next;
        }

        int left =0;
        int right = l.size()-1;


        while(left< right){
            if(!l.get(left).equals(l.get(right))){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}