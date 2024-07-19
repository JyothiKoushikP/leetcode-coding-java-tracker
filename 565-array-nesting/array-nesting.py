class Solution(object):
    depthMap = {}
    def arrayNesting(self, nums):
        Solution.depthMap = {}
        maxDepth = 0
        for i in range(len(nums)):
            if nums[i] == i:
                maxDepth = max(maxDepth,1)
            elif i in Solution.depthMap:
                maxDepth = max(maxDepth,Solution.depthMap[i])
            else:
                visited = set()
                d = self.dfs(nums,i,visited,1)
                maxDepth = max(maxDepth,d)
        
        return maxDepth

    def dfs(self,nums,k,visited,depth):
        if nums[k] in visited:
            return depth-1
        
        visited.add(nums[k])
        d = self.dfs(nums,nums[k],visited,depth + 1)
        Solution.depthMap[nums[k]] = d
        return d


        