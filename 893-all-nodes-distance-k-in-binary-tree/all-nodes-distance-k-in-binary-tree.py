# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class TreeNodeP(object):
    def __init__(self,x,left=None,right=None,parent = None):
        self.val = x
        self.left = left
        self.right = right
        self.parent = parent

class Solution(object):
    target_node = None

    def distanceK(self, root, target, k):
        three_way_tree = self.convertTo3Tree(root,target,None)
        bfs_map = {}
        self.bfs(self.target_node,bfs_map)
        result = []

        if k in bfs_map:
            for i in bfs_map[k]:
                result.append(i)

        return result

    def bfs(self, node, bfs_map):
        visited = set()
        q = deque()
        q.appendleft(node)
        visited.add(node)
        bfs_map[0] = [node.val]
        p, c, distance = 1,0,1
        while len(q) > 0:
            curr = q.pop()
            p -= 1

            if distance not in bfs_map:
                bfs_map[distance] = []
            if curr.parent is not None and curr.parent not in visited:
                bfs_map[distance].append(curr.parent.val) 
                visited.add(curr.parent)
                q.appendleft(curr.parent)
                c += 1

            if curr.left is not None and curr.left not in visited:
                bfs_map[distance].append(curr.left.val) 
                visited.add(curr.left)
                q.appendleft(curr.left)
                c += 1

            if curr.right is not None and curr.right not in visited:
                bfs_map[distance].append(curr.right.val) 
                visited.add(curr.right)
                q.appendleft(curr.right)
                c += 1
            
            if p == 0:
                p = c
                c = 0
                distance += 1

    def convertTo3Tree(self, node, target, parent_node):
        if node is None:
            return None

        x = TreeNodeP(node.val)
        x.parent = parent_node
        if x.val == target.val:
            self.target_node = x
        
        if node.left is None and node.right is None:
            return x
        
        left_sub_tree, right_sub_tree = None, None
        if node.left is not None:
            left_sub_tree = self.convertTo3Tree(node.left, target, x)
        if node.right is not None:
            right_sub_tree = self.convertTo3Tree(node.right,target,x)

        x.left = left_sub_tree
        x.right = right_sub_tree

        return x

        