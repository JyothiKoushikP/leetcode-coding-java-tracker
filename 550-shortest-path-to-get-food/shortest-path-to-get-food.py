class Solution(object):
    def getFood(self, grid):
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        m,n = len(grid),len(grid[0])
        visited = set()
        q = deque()
        entrance = [0,0]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "*":
                    entrance[0],entrance[1] = i,j
                    break

        q.append(entrance)
        distance = 0
        atEntrace = True
        visited.add((entrance[0],entrance[1]))
        while len(q) > 0:
            length = len(q)
            while length > 0:
                r,c = q.popleft()
                if grid[r][c] == '#':
                    return distance
                if atEntrace:
                    atEntrace = False
                for direction in directions:
                    nR,nC = r + direction[0],c + direction[1]
                    if nR >= 0 and nR < m and nC >= 0 and nC < n:
                        if (nR,nC) not in visited and grid[nR][nC] != "X":
                            q.append([nR,nC])
                            visited.add((nR,nC))
                length -= 1
            distance += 1
        
        return -1
        