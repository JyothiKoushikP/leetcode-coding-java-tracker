class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        track = {}
        sum = 0
        for i in nums:
            if i not in track:
                track[i] = 1
            else:
                sum += track[i]
                track[i] += 1

        return sum