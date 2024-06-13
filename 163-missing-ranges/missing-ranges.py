class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        result = []
        current = lower
        index = 0
        if len(nums) == 0:
            lst = [lower,upper]
            result.append(lst)
            return result
        while index < len(nums) and current <= upper:
            if nums[index] == current:
                index += 1
                current += 1
            else:
                lst = [current, nums[index] - 1]
                result.append(lst)
                current = nums[index] + 1
                index += 1
        if current <= upper:
            lst = [current, upper]
            result.append(lst)
        return result
        