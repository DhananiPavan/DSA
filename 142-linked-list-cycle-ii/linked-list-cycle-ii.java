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
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head==null || head.next==null){
        return null;
       } 
       ListNode slow=head;
       ListNode fst=head;
       while(fst!=null && fst.next!=null){
            slow=slow.next;
            fst=fst.next.next;
            if(slow==fst){
                break;
            }
       }
       if(slow!=fst){
        return null;
       }
       slow=head;
       while(slow!=fst){
        slow=slow.next;

        fst=fst.next;

       }
       return slow;//fst
    }
}