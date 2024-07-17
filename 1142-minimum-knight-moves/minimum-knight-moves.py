from collections import deque
class Solution(object):
    def minKnightMoves(self, x, y):
        directions = [
            (2, 1),   
            (2, -1),  
            (-2, 1),  
            (-2, -1), 
            (1, 2),   
            (1, -2),  
            (-1, 2),  
            (-1, -2)  
        ]
        q = deque()
        q.append([0,0])
        visited = set()
        visited.add((0,0))
        distance = 0
        while len(q) > 0:
            l = len(q)
            while l > 0:
                r,c = q.popleft()
                if r == x and c == y:
                    return distance
                for dirs in directions:
                    nR,nC = r + dirs[0],c + dirs[1]
                    if (nR,nC) not in visited:
                        visited.add((nR,nC))
                        q.append([nR,nC])
                l -= 1
            distance += 1

        return -1

        