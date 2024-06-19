class Solution(object):
    def countCompleteDayPairs(self, hours):
        map = {}
        count = 0
        for hour in hours:
            rem = hour % 24
            if rem == 0:
                count += map.get(rem,0)
            else:
                complement = 24 - rem
                count += map.get(complement,0)
            map[rem] = map.get(rem,0) + 1
            
        return count
        