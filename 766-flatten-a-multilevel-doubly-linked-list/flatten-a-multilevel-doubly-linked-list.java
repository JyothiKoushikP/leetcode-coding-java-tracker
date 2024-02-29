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
        if(head == null) return null;
        Queue<Integer> q = new LinkedList<>();
        linkedListTraversal(head,q);
        Node start = new Node(q.remove());
        Node pointer = start;
        while(!q.isEmpty()) {
            Node newNode = new Node(q.remove());
            newNode.prev = pointer;
            pointer.next = newNode;
            pointer = pointer.next;
        }
        return start;
    }

    public void linkedListTraversal(Node node, Queue<Integer> q) {
        if(node == null) {
            return;
        }
        q.add(node.val);
        linkedListTraversal(node.child,q);
        linkedListTraversal(node.next,q);
    }
}