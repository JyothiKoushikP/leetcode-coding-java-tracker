class Solution(object):
    def threeSumSmaller(self, nums, target):
        sum = 0
        nums.sort()
        for i in range(len(nums)):
            left, right = i+1, len(nums) - 1
            while left < right:
                if nums[i] + nums[left] + nums[right] < target:
                    sum += right - left
                    left += 1
                else:
                    right -= 1
        
        return sum


                    
        