class Solution(object):
    def find132pattern(self, nums):
        min_n = [0] * len(nums)
        current_min = float("inf")

        for i in range(len(nums)):
            current_min = min(current_min,nums[i])
            min_n[i] = current_min
        
        stack = []
        for j in range(len(nums)-1,-1,-1):
            if nums[j] <= min_n[j]:
                continue
            while stack and stack[-1] <= min_n[j]:
                stack.pop()
            if stack and stack[-1] < nums[j]:
                return True
            stack.append(nums[j])
        return False

            
        