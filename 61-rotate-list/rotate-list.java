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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null|| k==0){
            return head;
        }

       ListNode fst=head;
       int i =0;
       ListNode cur=head;
       while(cur!=null){
        cur=cur.next;
        i++;
       }
       int n=i;
       k=k%n;
       if(k==0)return head;
       i=1;
       while(i<=k){
        fst=fst.next;
        i++;
       } 
       ListNode slow=head;
       while(fst.next!=null){
        slow=slow.next;
        fst=fst.next;
       }
       ListNode newNode =slow.next;
       slow.next=null;
       fst.next=head;
       return newNode;

    }
}