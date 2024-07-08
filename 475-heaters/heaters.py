class Solution(object):
    def findRadius(self, houses, heaters):
        heaters.sort()
        minDistance = 0
        for house in houses:
            leftHeater = self.findLeftClosestHeater(heaters,house)
            rightHeater = self.findRightClosestHeater(heaters,house)
            if leftHeater == -1:
                minDistance = max(minDistance,rightHeater - house)
            elif rightHeater == -1:
                minDistance = max(minDistance,house - leftHeater)
            else:
                minDistance = max(minDistance,min(house - leftHeater, rightHeater - house))
        
        return minDistance

    
    def findLeftClosestHeater(self, heaters, target):
        start, end = 0, len(heaters) - 1
        heater = -1
        while start <= end:
            mid = (start + end) // 2
            if heaters[mid] < target:
                heater = heaters[mid]
                start = mid + 1
            elif heaters[mid] > target:
                end = mid - 1
            else:
                return heaters[mid]
        
        return heater

    def findRightClosestHeater(self, heaters, target):
        start, end = 0, len(heaters) - 1
        heater = -1
        while start <= end:
            mid = (start + end) // 2
            if heaters[mid] < target:
                start = mid + 1
            elif heaters[mid] > target:
                heater = heaters[mid]
                end = mid - 1
            else:
                return heaters[mid]
        
        return heater
        