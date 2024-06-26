# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def balanceBST(self, root):
        inorder_list = []
        self.inorderTraversal(root,inorder_list)
        return self.balanceBinaryTree(inorder_list,0,len(inorder_list)-1)
    
    def balanceBinaryTree(self,inorder_list,low,high):
        if low > high:
            return None
        
        mid = low + (high - low)/2
        node = TreeNode(inorder_list[mid])
        
        node.left = self.balanceBinaryTree(inorder_list,low,mid-1)
        node.right = self.balanceBinaryTree(inorder_list,mid+1,high)

        return node

    def inorderTraversal(self, node, inorder_list):
        if node.left is None and node.right is None:
            inorder_list.append(node.val)
            return
        if node.left is not None:
            self.inorderTraversal(node.left,inorder_list)
        inorder_list.append(node.val)
        if node.right is not None:
            self.inorderTraversal(node.right,inorder_list)
        
        return
        