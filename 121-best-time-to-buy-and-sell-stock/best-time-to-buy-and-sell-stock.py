class Solution(object):
    def maxProfit(self, prices):
        min_start_cost = float("inf")
        max_profit = 0
        for price in prices:
            if min_start_cost < price:
                max_profit = max(max_profit,price - min_start_cost)
            min_start_cost = min(min_start_cost,price)
        
        return max_profit
        