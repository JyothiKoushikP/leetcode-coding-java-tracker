from collections import deque

class Solution(object):
    def shortestDistance(self, grid):
        no_of_buildings = 0
        layout, common_buildings = [], []
        common_buildings = [row[:] for row in grid]
        layout = [row[:] for row in grid]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    no_of_buildings += 1
                    self.bfs(grid,layout,common_buildings,i,j)

        min_distance = float("inf")
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0 and common_buildings[i][j] == no_of_buildings:
                    min_distance = min(min_distance,layout[i][j])
        
        return -1 if min_distance == float("inf") else min_distance

    def bfs(self, grid, layout, common_buildings, row, column):
        dirs = [[-1,0],[0,-1],[0,1],[1,0]]
        distance,curr,next = 1,1,0
        rows, columns = len(grid), len(grid[0])
        visited = []
        for i in range(rows):
            row_entry = [False] * (columns)
            visited.append(row_entry)
        
        queue = deque()
        queue.append([row,column])
        visited[row][column] = True

        while len(queue) != 0:
            entry = queue.popleft()
            curr -= 1
            r, c = entry[0],entry[1]
            for direction in dirs:
                nr = r + direction[0]
                nc = c + direction[1]
                if nr >= 0 and nr < rows and nc >= 0 and nc < columns:
                    if grid[nr][nc] == 0 and not visited[nr][nc]:
                        common_buildings[nr][nc] += 1
                        queue.append([nr,nc])
                        visited[nr][nc] = True
                        layout[nr][nc] += distance
                        next += 1
            if curr == 0:
                distance += 1
                curr = next
                next = 0
        
