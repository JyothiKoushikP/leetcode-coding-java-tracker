class LRUCache {

    Map<Integer,Node> track = new HashMap<>();
    int totalCapacity;
    DLL dl = new DLL();

    public LRUCache(int capacity) {
        totalCapacity = capacity;
    }
    
    public int get(int key) {
        if(!track.containsKey(key)) {
                return -1;
            }
        int value = track.get(key).data;
        Node pushed = dl.pushNode(track.get(key));
        track.put(key,pushed);
        return value;
    }
    
    public void put(int key, int value) {
        if(track.containsKey(key)) {
            Node updated = dl.updateNode(track.get(key),value);
            track.put(key,updated);
        } else {
            if (track.size() == totalCapacity) {
                int removedKey = dl.evictKey();
                track.remove(removedKey);
            }
                Node na = dl.addNode(key, value);
                track.put(key, na);
        }
    }

}

class DLL {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Node addNode(int key, int value) {
        if(head == null) {
            head = new Node(key,value);
            tail = head;
            return head;
        }

        Node newNode = new Node(key,value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return newNode;
    }

    public Node updateNode(Node node,int value) {
        node.data = value;
        node = pushNode(node);
        return node;
    }

    public Node pushNode(Node node) {
        if(head == tail || node.next == null) {
            return node;
        }
        Node pP = node.prev;
        Node nP = node.next;
        if(pP == null) {
            head = head.next;
            head.prev = null;
        } else {
            pP.next = nP;
            nP.prev = pP;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;

        return node;
    }

    public int evictKey() {
        if(head == null) return -1;
        int removed;
        if(head.next == null) {
            removed = head.key;
            head = null;
            tail = null;
        } else {
            removed = head.key;
            head = head.next;
            head.prev = null;
        }
        return removed;
    }


}

class Node {
    Node next;
    Node prev;
    int key;
    int data;

    public Node(int key, int value) {
        this.key = key;
        this.data = value;
    }
}






/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */