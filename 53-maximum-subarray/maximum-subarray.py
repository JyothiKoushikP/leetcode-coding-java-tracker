class Solution(object):
    def maxSubArray(self, nums):
        maxSum, total = nums[0], 0
        for i in nums:
            total += i
            maxSum = max(maxSum,total)
            if total < 0:
                total = 0
        
        return maxSum
        