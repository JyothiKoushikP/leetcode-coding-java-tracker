class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            if d.get(target-nums[i])!=None:
                return [d.get(target-nums[i]),i]
            d[nums[i]] = i
        return [-1,-1]