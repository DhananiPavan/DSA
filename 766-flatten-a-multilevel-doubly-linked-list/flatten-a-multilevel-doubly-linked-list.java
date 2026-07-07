/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    // Returns the tail of the flattened list
    private Node dfs(Node node) {

        Node curr = node;
        Node last = null;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                // Connect current -> child
                curr.next = childHead;
                childHead.prev = curr;

                // Remove child pointer
                curr.child = null;

                // Connect child tail -> next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}