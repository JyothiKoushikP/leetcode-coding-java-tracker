class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        maxi = max(nums)
        freq = [0] * (maxi + 1)

        for i in nums:
            freq[i] += 1
        
        for i in range(1,len(freq)):
            freq[i] += freq[i-1]
        
        result = [0] * len(nums)
        for i in range(len(nums)):
            x = nums[i]
            result[i] = freq[x-1] if x >= 1 else 0

        return result



        