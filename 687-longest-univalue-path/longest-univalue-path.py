# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    lup = 0
    def longestUnivaluePath(self, root):
        if root is None: return 0
        self.lup = 0
        self.calculate_longest_path(root)
        return self.lup - 1

    def calculate_longest_path(self, node):
        if node.left is None and node.right is None:
            self.lup = max(self.lup,1)
            return node.val, 1
        
        left_node, right_node = float("inf"), float("inf")
        left_path, right_path = float("inf"), float("inf")

        if node.left is not None:
            left_node, left_path = self.calculate_longest_path(node.left)
        
        if node.right is not None:
            right_node, right_path = self.calculate_longest_path(node.right)

        llp = 1 + (left_path if left_node == node.val else 0)
        rlp = 1 + (right_path if right_node == node.val else 0)
        clp = 1 + (left_path if left_node == node.val else 0) + (right_path if right_node == node.val else 0)

        self.lup = max(clp,rlp,llp,self.lup)

        return node.val,max(llp,rlp)


        