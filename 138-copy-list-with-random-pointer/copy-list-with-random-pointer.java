/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a new cloned node for each existing node 
        // and link them together by interweaving them.
        // Original: A -> B -> C
        // Interwoven: A -> A' -> B -> B' -> C -> C'
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step 2: Assign random pointers for the cloned nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore the original list and extract the cloned list.
        curr = head;
        Node cloneHead = head.next;
        Node currClone = cloneHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (currClone.next != null) {
                currClone.next = currClone.next.next;
            }
            curr = curr.next;
            currClone = currClone.next;
        }

        return cloneHead;
    }
}