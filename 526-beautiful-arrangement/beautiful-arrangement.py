class Solution(object):
    total_count = 0
    def countArrangement(self, n):
        Solution.total_count = 0
        nums = [(i+1) for i in range(n)]
        track = [0] * n
        arr = []
        self.count_total(nums,track,arr,0,n)

        return Solution.total_count


    
    def count_total(self,nums,track,arr,position,n):
        if position == n:
            Solution.total_count += 1
            return
        
        for i in range(len(nums)):
            if track[i] != -1:
                if (nums[i] % (position + 1) == 0) or ((position + 1) % nums[i] == 0):
                    arr.append(nums[i])
                    track[i] = -1
                    self.count_total(nums,track,arr,position + 1,n)
                    arr.pop()
                    track[i] = 0
        
        return
        
        

        