"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        if root == None:
            return None

        count = 1
        n = 0
        queue = deque()
        queue.append(root)
        prev = None

        while len(queue) > 0:
            c = queue.popleft()
            count -= 1

            if count > 0:
                if prev == None:
                    prev = c
                else:
                    prev.next = c
                    prev = c
            else:
                if prev != None:
                    prev.next = c
                c.next = None

            if c.left != None:
                queue.append(c.left)
                n += 1
            if c.right != None:
                queue.append(c.right)
                n += 1

            if count == 0:
                count = n
                n = 0
                prev = None

        return root
