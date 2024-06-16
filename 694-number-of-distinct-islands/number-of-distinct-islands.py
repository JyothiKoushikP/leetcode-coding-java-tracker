class Solution(object):
    dirs = [[0,1],[1,0],[0,-1],[-1,0]]
    def numDistinctIslands(self, grid):
        island_layout = []
        unique_islands = set()
        visited = []
        
        for i in range(len(grid)):
            row = [False] * len(grid[0])
            visited.append(row)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 and not visited[i][j]:
                    island_layout = []
                    self.dfs(grid,visited,island_layout,i,j,0,0)
                    unique_islands.add(tuple(island_layout))
        
        return len(unique_islands)

    def dfs(self,grid,visited,island_layout,r,c,tr,tc):
        if grid[r][c] == 0:
            return

        visited[r][c] = True
        island_layout.append(str(tr) + str(tc))
        
        for direction in self.dirs:
            nr = r + direction[0]
            nc = c + direction[1]
            if(nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]) and not visited[nr][nc]):
                self.dfs(grid,visited,island_layout,nr,nc,tr + direction[0],tc + direction[1])
        
        return 


        