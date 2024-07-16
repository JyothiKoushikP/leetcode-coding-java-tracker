# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    max_path = 0
    def longestZigZag(self, root):
        Solution.max_path = 0
        self.track(root)
        return Solution.max_path
    
    def track(self, node):
        if not node.left and not node.right:
            return [0,0]
        
        leftCount, rightCount = 0,0
        if node.left:
            leftCount = 1 + self.track(node.left)[1]
        if node.right:
            rightCount = 1 + self.track(node.right)[0]
        
        Solution.max_path = max(leftCount,rightCount,Solution.max_path)

        return [leftCount,rightCount]
        