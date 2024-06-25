# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    is_balanced = True
    def isBalanced(self, root):
        if root is None: return self.is_balanced
        self.dfs(root,0)
        return self.is_balanced
    
    def dfs(self, node, level):
        if node.left is None and node.right is None:
            return level
        
        left_height, right_height = level,level
        if node.left is not None:
            left_height = self.dfs(node.left,level + 1)
        
        if node.right is not None:
            right_height = self.dfs(node.right, level + 1)
        
        if abs(left_height - right_height) > 1:
            self.is_balanced = False
        
        return max(left_height,right_height)
        