# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    max_value = -float("inf")
    def maxPathSum(self, root):
        self.dfs(root)
        return self.max_value

    def dfs(self, node):
        if node.left is None and node.right is None:
            self.max_value = max(self.max_value,node.val)
            return node.val
        
        left_sum, right_sum = -float("inf"), -float("inf")
        if node.left is not None:
            left_sum = self.dfs(node.left)
        if node.right is not None:
            right_sum = self.dfs(node.right)
        
        original_node_value = node.val
        left_path_sum = node.val + (left_sum if left_sum != -float("inf") else 0)
        right_path_sum = node.val + (right_sum if right_sum != -float("inf") else 0)
        cumulative_path = node.val + (left_sum if left_sum != -float("inf") else 0) + (right_sum if right_sum != -float("inf") else 0)
        maximum_path_sum = max(max(original_node_value,left_path_sum),max(right_path_sum,cumulative_path))
        self.max_value = max(self.max_value,maximum_path_sum)

        return max(left_path_sum,max(right_path_sum,original_node_value))
        