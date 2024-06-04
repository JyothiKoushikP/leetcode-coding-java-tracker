class Solution(object):
    pathList = []

    def pathSum(self, nums):
        self.pathList = []
        levels = []
        for i in range(1,5):
            level = [float("inf")] * (2**(i-1))
            levels.append(level)

        for num in nums:
            level = float("inf")
            index = float("inf")
            value = float("inf")
            while num > 0:
                rem = num % 10
                if value == float("inf"):
                    value = rem
                elif index == float("inf"):
                    index = rem
                elif level == float("inf"):
                    level = rem
                num /= 10
            
            levels[level-1][index-1] = value

        self.dfsPathSum(levels,0,0,0)
        sum = 0
        print(self.pathList)
        for i in self.pathList:
            sum += i

        return sum
    
    def dfsPathSum(self,levels, level, index, sum):
        if (level + 1 >= len(levels) or (2*index) >= len(levels[level+1]) or levels[level+1][(2*index)] == float("inf")) and (level + 1 >= len(levels) or (2*index) + 1 >= len(levels[level+1]) or levels[level+1][(2*index)+1] == float("inf")):
            self.pathList.append(sum + levels[level][index])
            return
        
        if not (level + 1 >= len(levels) or (2*index) >= len(levels[level+1]) or levels[level+1][(2*index)] == float("inf")):
            self.dfsPathSum(levels,level+1,(2*index),sum + levels[level][index])
        if not (level + 1 >= len(levels) or (2*index) + 1 >= len(levels[level+1]) or levels[level+1][(2*index) + 1] == float("inf")):
            self.dfsPathSum(levels,level+1,(2*index)+1,sum + levels[level][index])

        return



        

