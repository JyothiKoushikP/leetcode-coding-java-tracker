# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution(object):
    max_diameter = [0]

    def diameterOfBinaryTree(self, root):
        self.max_diameter[0] = 0  # Reset max_diameter for each call
        i = self.recursive_diameter(root, 0)
        return self.max_diameter[0]

    # Recursive function to calculate diameter
    def recursive_diameter(self, node, level):
        if node is None:
            return level
        ml = level
        mr = level
        if node.left is not None:
            ml = self.recursive_diameter(node.left, level + 1)
        if node.right is not None:
            mr = self.recursive_diameter(node.right, level + 1)
        self.max_diameter[0] = max(self.max_diameter[0], (ml - level) + (mr - level))
        return max(ml, mr)
    