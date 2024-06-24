# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    inorder_list = []

    def findTarget(self, root, k):
        self.inorder_list = []
        self.inOrder(root)
        hash_set = set()
        for i in self.inorder_list:
            complement = k - i
            if complement in hash_set:
                return True
            hash_set.add(i)
        
        return False

    def inOrder(self,node):
        if node.left is None and node.right is None:
            self.inorder_list.append(node.val)
            return
        if node.left is not None:
            self.inOrder(node.left)
        self.inorder_list.append(node.val)
        if node.right is not None:
            self.inOrder(node.right)
        
        return
        