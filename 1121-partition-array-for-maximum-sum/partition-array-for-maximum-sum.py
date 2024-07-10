class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        dp = [-1] * len(arr)
        self.recursiveApproach(arr,dp,0,k)
        return dp[0]
        
    def recursiveApproach(self,arr,dp,index,k):
        max_num = -float("inf")
        max_sum = 0
        current_sum = 0
        for i in range(index,index + k):
            if i >= len(arr):
                break
            else:
                max_num = max(max_num,arr[i]) 
                current_sum = max_num * (i - index + 1)
                if i + 1 < len(arr):
                    if dp[i+1] != -1:
                        current_sum += dp[i+1]
                    else:
                        current_sum += self.recursiveApproach(arr,dp,i + 1,k)

                max_sum = max(current_sum,max_sum)
        
        dp[index] = max_sum
        return max_sum