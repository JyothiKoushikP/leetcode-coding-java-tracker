# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def invertTree(self, root):
        if root is None: return root
        return self.invert_tree(root)
    
    def invert_tree(self, node):
        if node.left is None and node.right is None:
            return node
        
        left_node, right_node = None, None

        if node.left is not None:
            left_node = self.invert_tree(node.left)
        
        if node.right is not None:
            right_node = self.invert_tree(node.right)
        
        node.left = right_node
        node.right = left_node
        return node
        