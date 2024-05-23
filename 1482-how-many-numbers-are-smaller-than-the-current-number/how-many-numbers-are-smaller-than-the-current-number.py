class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        ps = [0] * 102
        for i in nums:
            ps[i] += 1

        for i in range(1, len(ps)):
            ps[i] += ps[i - 1]

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i] = ps[nums[i] - 1]
        
        return nums