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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!st.isEmpty() && st.peek() < cur.val) {
                st.pop();
            }
            st.push(cur.val);
            cur = cur.next;
        }
        ListNode newhead = new ListNode(0);
        ListNode curr = newhead;

        for (int x : st) {
            curr.next = new ListNode(x);
            curr = curr.next; // Move forward
        }

        return newhead.next;
    }
}