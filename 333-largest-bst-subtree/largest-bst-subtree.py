
from sys import maxsize# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    maxSize = 0
    def largestBSTSubtree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None: return 0
        self.dfsLargestSubTree(root)
        return self.maxSize
        
    def dfsLargestSubTree(self,node):
        if node.left is None and node.right is None:
            self.maxSize = max(self.maxSize,1)
            return [node.val, node.val], 1, True

        l_values, l_size, is_l = [],0,False
        r_values, r_size, is_r = [],0,False
        
        if node.left is not None:
            l_values, l_size, is_l = self.dfsLargestSubTree(node.left)

        if node.right is not None:
            r_values, r_size, is_r = self.dfsLargestSubTree(node.right)

        values, size, is_binary = [node.val,node.val], 0, False

        if node.left is None and node.right is not None:
            if r_values[0] > node.val and is_r:
                size = 1 + r_size
                self.maxSize = max(self.maxSize,size)
                is_binary = True
                values[0] = (node.val)
                values[1] = (r_values[1])
            else:
                values[0] = min(node.val,min(r_values))
                values[1] = max(node.val,max(r_values))
        elif node.right is None and node.left is not None:
            if l_values[1] < node.val and is_l:
                size = 1 + l_size
                self.maxSize = max(self.maxSize,size)
                is_binary = True
                values[0] = (l_values[0])
                values[1] = (node.val)
            else:
                values[0] = min(node.val,min(l_values))
                values[1] = max(node.val,max(l_values))
        else:
            if (l_values[1] < node.val and is_l) and (r_values[0] > node.val and is_r):
                size = 1 + l_size + r_size
                self.maxSize = max(self.maxSize,size)
                is_binary = True
                values[0] = (l_values[0])
                values[1] = (r_values[1])
            else:
                values[0] = min(node.val, min(min(l_values),min(r_values)))
                values[1] = max(node.val,max(max(l_values),max(r_values)))
        
        return values, size, is_binary
        





        



        minVal = min(min(l_values),min(r_values))
        maxVal = max(max(l_values),max(r_values))
        values.append(minVal)
        values.append(maxVal)

        return values, size, is_binary

        return [],0,True


