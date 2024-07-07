class Solution(object):
    def furthestBuilding(self, heights, bricks, ladders):
        start, end = 0, len(heights) - 1
        building = 0
        while start <= end:
            mid = (start + end) // 2;
            if self.isReachable(mid,heights,bricks,ladders):
                building = mid
                start = mid + 1
            else:
                end = mid - 1
        
        return building

        
    def isReachable(self, index, buildings, bricks, ladders):
        height = []
        for i in range(index):
            h1 = buildings[i]
            h2 = buildings[i+1]
            if(h1 < h2):
                height.append(h2 - h1)
        height.sort()

        for h in height:
            if bricks >= h:
                bricks -= h
            elif ladders >= 1:
                ladders -= 1
            else:
                return False
        
        return True