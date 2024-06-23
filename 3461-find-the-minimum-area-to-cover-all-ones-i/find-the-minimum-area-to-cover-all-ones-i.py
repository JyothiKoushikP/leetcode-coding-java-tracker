class Solution(object):
    def minimumArea(self, grid):
        left, right = float("inf"), -float("inf")

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    left = min(left,j)
                    right = max(right,j)
        
        up, down = float("inf"), -float("inf")

        for i in range(len(grid[0])):
            for j in range(len(grid)):
                if grid[j][i] == 1:
                    up = min(up,j)
                    down = max(down,j)
        
        return (right - left + 1) * (down - up + 1)
        