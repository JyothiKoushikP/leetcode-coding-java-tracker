# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution(object):    
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []

        if root == None:
            return result

        colTrack = {}
        maxMinTrack = [0,0]
        q = deque()
        curr = 1
        n = 0
        q.append([0,root])
        
        while len(q) > 0:
            l = q.popleft()
            curr -= 1

            node = l[1]
            column = l[0]

            maxMinTrack[0] = min(maxMinTrack[0],column)
            maxMinTrack[1] = max(maxMinTrack[1],column)

            if column not in colTrack.keys():
                colTrack[column] = []
            
            colTrack[column].append(node.val)

            if node.left != None:
                q.append([column-1,node.left])
                n += 1
            if node.right != None:
                q.append([column+1,node.right])
                n += 1

            if curr == 0:
                curr = n
                n = 0
        
        for i in range(maxMinTrack[0],maxMinTrack[1] + 1):
            result.append(colTrack[i])
        
        return result