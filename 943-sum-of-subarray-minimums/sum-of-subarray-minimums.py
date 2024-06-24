class Solution(object):
    def sumSubarrayMins(self, arr):
        left_stack = []
        right_stack = []

        left_max = [0] * len(arr)
        right_max = [0] * len(arr)

        # monotonic increasing stack from left
        for i in range(len(arr)):
            curr = arr[i]
            while len(left_stack) > 0 and left_stack[-1][1] > curr:
                left_stack.pop()
            if len(left_stack) == 0:
                left_max[i] = 0
            else:
                left_max[i] = left_stack[-1][0] + 1

            left_stack.append([i,curr])
        
        # monotonic increasing stack from right_max
        for i in range(len(arr)-1,-1,-1):
            curr= arr[i]
            while len(right_stack) > 0 and right_stack[-1][1] >= curr:
                right_stack.pop()
            
            if len(right_stack) == 0:
                right_max[i] = len(arr) - 1
            else:
                right_max[i] = right_stack[-1][0] - 1

            right_stack.append([i,curr])
        
        total = 0

        MOD = 10**9 + 7

        for i in range(len(arr)):
            curr = arr[i]
            total += (curr * ((i - left_max[i] + 1) * (right_max[i] - i + 1))) % MOD
            total %= MOD

        return total


        