class Solution(object):
    dirs = [[0,1],[0,-1],[1,0],[-1,0]]

    def maxAreaOfIsland(self, grid):
        visited = []
        for i in range(len(grid)):
            row = [False] * len(grid[0])
            visited.append(row)
        
        maxArea = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 and not visited[i][j]:
                    maxArea = max(maxArea,self.dfs(grid,i,j,visited))
            
        return maxArea

    def dfs(self,grid,row,column,visited):
        if grid[row][column] == 0:
            return 0
        
        visited[row][column] = True

        total = 0

        for direction in self.dirs:
            nr = row + direction[0]
            nc = column + direction[1]
            if nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]):
                if not visited[nr][nc]:
                    total += self.dfs(grid,nr,nc,visited)
        
        return total + 1        