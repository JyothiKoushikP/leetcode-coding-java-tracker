class LRUCache {
    Map<Integer,DLLNode> cache;
    DoublyLinkedList dll;
    int totalSize;

    public LRUCache(int capacity) {
        totalSize = capacity;
        dll = new DoublyLinkedList();
        cache = new HashMap();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            dll.moveToFront(node);
            return cache.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if(cache.size() == totalSize) {
                int k = dll.getHead().key;
                dll.evictLRUKey();
                cache.remove(k);
            }
            DLLNode node = dll.addElement(key,value);
            cache.put(key,node);
        }
    }

}

class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key,int value) {
        this.key = key;
        this.value = value;
    }
}


public class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;

    public DLLNode getHead() {
        return head;
    }
    
    public DLLNode addElement(int key, int value) {
        DLLNode temp = new DLLNode(key,value);
        if(head == null) {
            head = temp;
            tail = head;
        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        return temp;
    }

    public void evictLRUKey() {
        if(head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    
    }

    public void moveToFront(DLLNode node) {
        if(head == tail || node.next == null) {
            return;
        }
        if(node.prev == null) {
            head = head.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */