class Solution(object):
    def shipWithinDays(self, weights, days):
        least_capacity = max(weights)
        highest_capacity = sum(weights)

        start, end = least_capacity, highest_capacity

        result = 0
        while start < end:
            mid = start + (end - start) / 2
            if self.isCapacityWithinDays(weights,mid,days):
                end = mid
            else:
                start = mid + 1
        
        return start

    
    def isCapacityWithinDays(self,weights,capacity, days):
        numberOfDays = 1
        total_sum = 0
        for i in weights:
            total_sum += i
            if total_sum > capacity:
                numberOfDays += 1
                total_sum = i
            
        return numberOfDays <= days

        