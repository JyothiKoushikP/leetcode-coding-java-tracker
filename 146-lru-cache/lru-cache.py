class ListNode:
    def __init__(self,key,value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache(object):
    def __init__(self, capacity):
        self.capacity = capacity
        self.map = {}
        self.head = ListNode(-1,-1)
        self.tail = ListNode(-1,-1)
        
    def get(self, key):
        if key not in self.map:
            return -1
        else:
            current_node = self.map[key]
            value = current_node.value
            self.moveToTail(key,current_node)
            return value
        
    def put(self, key, value):
        if key not in self.map:
            if len(self.map) == self.capacity:
                key_to_remove = self.removeNode()
                x = self.map
                del self.map[key_to_remove]
            self.addNode(key,value)
        else:
            current_node = self.map[key]
            current_node.value = value
            self.moveToTail(key,current_node)

    def addNode(self,key,value):
        node = ListNode(key,value)
        if self.head.key == -1:
            self.head = node
            self.tail = node
        else:
            node.prev = self.tail
            self.tail.next = node
            self.tail = node
        self.map[key] = node
    
    def removeNode(self):
        removed_key = self.head.key
        if self.head.next is None:
            self.head = ListNode(-1,-1)
            self.tail = ListNode(-1,-1)
        else:
            self.head = self.head.next
            self.head.prev = None
        return removed_key

    def moveToTail(self,key,node):
        if node.next is None or self.head == self.tail:
            return node

        prev_node = node.prev
        next_node = node.next

        if prev_node is None:
            new_head = self.head.next
            new_head.prev = None
            self.head = new_head
        else:
            prev_node.next = next_node
            if next_node:
                next_node.prev = prev_node

        self.tail.next = node
        node.prev = self.tail
        node.next = None
        self.tail = node
        self.map[key] = node

        
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)