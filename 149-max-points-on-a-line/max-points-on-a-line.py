class Solution(object):
    def maxPoints(self, points):
        l = len(points)
        max_points = 0
        for i in range(l):
            map = defaultdict(int)
            for j in range(i+1,l):
                fx,fy = points[i]
                sx,sy = points[j]
                slope = 0
                if sy == fy:
                    slope = 0
                elif sx == fx:
                    slope = float("inf")
                else:
                    slope = float(sy-fy) / float(sx-fx)
                map[slope] += 1
                max_points = max(max_points,map[slope])
        
        return max_points + 1
                
    
        