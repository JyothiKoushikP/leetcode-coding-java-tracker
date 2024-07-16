# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderSuccessor(self, root, p):
        inorder_list = []
        self.dfs(inorder_list,root)
        for i in range(len(inorder_list)):
            if inorder_list[i].val == p.val:
                return inorder_list[i+1] if i+1 < len(inorder_list) else None
        
        return None
        
    def dfs(self,inorder_list,node):
        if not node.left and not node.right:
            inorder_list.append(node)
            return
        
        if node.left:
            self.dfs(inorder_list,node.left)
        inorder_list.append(node)
        if node.right:
            self.dfs(inorder_list,node.right)
        
        return
        