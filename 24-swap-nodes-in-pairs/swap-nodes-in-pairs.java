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
    public ListNode swapPairs(ListNode head) {
     if(head==null || head.next==null){
        return head;
     }
     ListNode dummy=new ListNode(0);
     dummy.next=head;
     ListNode prev=dummy;
     while(prev.next!=null && prev.next.next!=null){
        ListNode slow=prev.next;
        ListNode fst=prev.next.next;
        slow.next=fst.next;
        fst.next=slow;
        prev.next=fst;
        prev=slow;
     }   


     return dummy.next;
    
    }
}