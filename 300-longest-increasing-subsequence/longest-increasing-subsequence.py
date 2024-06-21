class Solution(object):
    def lengthOfLIS(self, nums):
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(0,i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i],dp[j] + 1)
        
        return max(dp)
        