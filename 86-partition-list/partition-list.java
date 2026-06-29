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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
     List<Integer> ls= new ArrayList<>();
     List<Integer> gs= new ArrayList<>();
     ListNode temp=head;
      while(temp!=null){
        if(temp.val<x){
            ls.add(temp.val);
        }
        else{
            gs.add(temp.val);
        }
        temp=temp.next;
      }
      temp=head;
      for(int v:ls){
        temp.val=v;
        temp=temp.next;
      }
       
      for(int v:gs){
        temp.val=v;
        temp=temp.next;
      }
      return head;
    }
}