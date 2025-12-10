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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;  // It's a palindrome by definition
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }

        ListNode newnode=reverse(slow.next);
        ListNode first=head;
        ListNode second=newnode;
        while(second!=null){
            if(first.val!=second.val){
                reverse(newnode);
                return false;

            }
            first=first.next;
            second=second.next;

        }
         reverse(newnode);
         return true;



        
    }
    public ListNode reverse(ListNode head){
          if (head == null || head.next == null) {
            return head;  // No change is needed; return the current head
        }
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse the link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }
        
        return prev;
    }
}