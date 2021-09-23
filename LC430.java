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
        if (head == null) {
            return head;
        }
        if (head.child != null) {
            Node temp = flatten(head.next);
            Node head2 = flatten(head.child);
            Node node = head2;
            while (node.next != null) {
                node = node.next;
            } // node is the tail of child list, node.next is null
            node.next = temp;
            if (temp != null) {
                temp.prev = node;
            }
            head.next = head2;
            if (head2 != null) {
                head2.prev = head;
            }
            head.child = null;
            return head;
        }
        else { // head.child is null
            Node temp = flatten(head.next);
            head.next = temp;
            if (temp != null) {
                temp.prev = head;
            }
            return head;
        }        
    }
}
