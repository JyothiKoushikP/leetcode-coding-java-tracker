class Solution(object):
    def findNumberOfLIS(self, nums):
        currMax = 1
        count = [defaultdict(int) for _ in range(len(nums))]
        cum = defaultdict(int)
        dp = [1] * len(nums)
        
        count[0][1] = 1
        cum[1] = 1

        for i in range(1, len(nums)):
            maxLen = 1
            count[i][1] = 1
            cum[1] += 1
            
            for j in range(i):
                if nums[j] < nums[i]:
                    count[i][dp[j] + 1] += count[j][dp[j]]
                    cum[dp[j] + 1] += count[j][dp[j]]
                    maxLen = max(maxLen, dp[j] + 1)
                    
            dp[i] = maxLen
            currMax = max(currMax, maxLen)
        
        return cum[currMax]

            
        