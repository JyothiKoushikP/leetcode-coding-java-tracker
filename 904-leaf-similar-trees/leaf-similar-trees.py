# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def leafSimilar(self, root1, root2):
        lst1 = []
        lst2 = []
        self.dfs(root1,lst1)
        self.dfs(root2,lst2)

        return lst1 == lst2
        
        
    def dfs(self,node,lst):
        if not node.left and not node.right:
            lst.append(node.val)
            return
        
        if node.left:
            self.dfs(node.left,lst)
        
        if node.right:
            self.dfs(node.right,lst)
        
        return