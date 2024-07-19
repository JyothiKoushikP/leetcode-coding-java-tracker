from collections import deque
class Solution(object):
    directions = [[0,1],[0,-1],[1,0],[-1,0]]
    def shortestBridge(self, grid):
        first_island = []
        m,n = len(grid), len(grid[0])
        shouldContinue = True
        for i in range(m):
            if shouldContinue:
                for j in range(n):
                    if shouldContinue and grid[i][j] == 1:
                        self.bfs(grid,i,j,m,n,first_island)
                        shouldContinue = False
                        break
        
        q = deque()
        distance = 0
        for points in first_island:
            q.append(points)
        
        while len(q) > 0:
            length = len(q)
            while length > 0:
                r,c = q.popleft()
                grid[r][c] = -1
                for direction in Solution.directions:
                    nR,nC = r + direction[0],c + direction[1]
                    if nR >= 0 and nR < m and nC >= 0 and nC < n:
                        if grid[nR][nC] == 0:
                            q.append([nR,nC])
                            grid[nR][nC] = -1
                        elif grid[nR][nC] == 1:
                            return distance
                length = length - 1
            distance = distance + 1
    
        return distance
    
    def bfs(self, grid, r, c, m, n, first_island):
        q = deque()
        q.append([r,c])
        grid[r][c] = -1
        first_island.append([r,c])
        while len(q) > 0:
            length = len(q)
            while length > 0:
                row,column = q.popleft()
                for direction in Solution.directions:
                    nR,nC = row + direction[0],column + direction[1]
                    if nR >= 0 and nR < m and nC >= 0 and nC < n:
                        if grid[nR][nC] != -1 and grid[nR][nC] == 1:
                            first_island.append([nR,nC])
                            q.append([nR,nC])
                            grid[nR][nC] = -1

                length = length - 1
        return 

