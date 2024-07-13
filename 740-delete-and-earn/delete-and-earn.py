

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        unique = set(nums)
        unique_list = list(unique)
        unique_list.sort()
        freq = Counter(nums)
        dp = [0] * len(unique_list)
        maxCount = 0
        for i in range(len(unique_list)-1,-1,-1):
            x = unique_list[i] * freq.get(unique_list[i])
            if i+1 < len(unique_list) and unique_list[i+1] != unique_list[i] + 1:
                x += dp[i+1]
            elif i+2 < len(unique_list):
                x += dp[i+2]

            maxCount = max(x,maxCount)
            dp[i] = maxCount
        
        return maxCount

        
