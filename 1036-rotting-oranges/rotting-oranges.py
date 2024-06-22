from collections import deque
import math
class Solution(object):
    directions = [[0,1],[0,-1],[1,0],[-1,0]]
    def orangesRotting(self, grid):
        rotten = [[float("inf")] * len(grid[0]) for h in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    visited = [[False] * len(grid[0]) for k in range(len(grid))]
                    self.bfs(grid,visited,rotten,i,j)
        
        max_minutes = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 or grid[i][j] == 2:
                    if rotten[i][j] == float("inf"):
                        return -1
                    else:
                        max_minutes = max(max_minutes,rotten[i][j])

        return max_minutes
        
    def bfs(self, grid, visited, rotten, row, column):
        q = deque()
        q.appendleft([row,column])
        rotten[row][column] = 0
        parent, children, minutes = 1, 0, 1
        while len(q) > 0:
            r,c = q.pop()
            parent -= 1
            for direction in self.directions:
                nr,nc = r + direction[0], c + direction[1]
                if nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]) and not visited[nr][nc]:
                    if grid[nr][nc] == 1:
                        q.appendleft([nr,nc])
                        rotten[nr][nc] = min(rotten[nr][nc],minutes)
                        visited[nr][nc] = True
                        children += 1
            if parent == 0:
                parent = children
                children = 0
                minutes += 1
        return

        