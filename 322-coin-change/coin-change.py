class Solution(object):
    def coinChange(self, coins, amount):
        dp = [0] * (amount + 1)
        for i in range(1,amount + 1):
            dp[i] = float("inf")
            for coin in coins:
                if coin <= i and dp[i-coin] != float("inf"):
                    dp[i] = min(dp[i],1 + dp[i-coin])
        
        return dp[amount] if dp[amount] != float("inf") else -1