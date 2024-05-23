class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        start, end = 0, len(nums) - 1
        while start <= end:
            if nums[start] == val:
                temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                end -= 1
            else:
                start += 1
        return start
