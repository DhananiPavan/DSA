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
    public boolean hasCycle(ListNode head) {
       if(head==null || head.next==null){
        return false;
       }
       ListNode slow=head;
       ListNode fst=head;
       
       
       while(  fst!=null && fst.next!=null ){
        slow=slow.next;
        fst=fst.next.next;
        if(slow==fst){
            return true;
        }
       } 
       

       return false;
    }
}