class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        track = {}
        for i in range(len(nums)):
            nTwo = target - nums[i]
            if nTwo in track and track[nTwo] != i:
                return [track[nTwo], i]
            track[nums[i]] = i

        return [-1, -1]