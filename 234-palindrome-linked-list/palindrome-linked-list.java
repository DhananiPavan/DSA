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
            return true;

        }
        ListNode slow = head;
        ListNode fst = head;
        while (fst != null && fst.next != null) {
            slow = slow.next;
            fst = fst.next.next;
        }
        ListNode newNode=null;
        if(fst!=null){
          newNode=reverse(slow.next);
        
        }
        else{
            newNode =reverse(slow);
        }
        ListNode left=head;
        ListNode right=newNode;
        while(right!=null){
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }

     return true;

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
        // 'prev' is now the head of the reversed second half!
    }
}