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
        Map<Node,Node> listTrack = new HashMap<>();
        Map<Integer,Node> indexTrack = new HashMap<>();
        int count = 0;
        Node copyList = new Node(-1);
        Node pointer = copyList;
        while(head != null) {
            Node newNode = listTrack.containsKey(head) ? listTrack.get(head) : new Node(head.val);
            if(head.random == head) {
                newNode.random = newNode;
            } else if(listTrack.containsKey(head.random)) {
                Node old = listTrack.get(head.random);
                newNode.random = old;
            } else if(head.random != null) {
                Node futureNode = new Node(head.random.val);
                listTrack.put(head.random,futureNode);
                newNode.random = futureNode;
            } 
            if(count != 0) {
                Node previous = indexTrack.get(count - 1);
                previous.next = newNode;
                indexTrack.put(count - 1, previous);
            }
            listTrack.put(head,newNode);
            indexTrack.put(count,newNode);
            count++;
            pointer.next = newNode;
            pointer = pointer.next;
            head = head.next;
        }
        return copyList.next;
    }
}
