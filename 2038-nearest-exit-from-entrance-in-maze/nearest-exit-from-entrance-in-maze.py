from collections import deque

class Solution(object):
    def nearestExit(self, maze, entrance):
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        m,n = len(maze),len(maze[0])
        visited = set()
        q = deque()
        q.append(entrance)
        distance = 0
        atEntrace = True
        visited.add((entrance[0],entrance[1]))
        while len(q) > 0:
            length = len(q)
            while length > 0:
                r,c = q.popleft()
                if not atEntrace and (r == 0 or r == m-1 or c ==0 or c == n-1):
                    return distance
                if atEntrace:
                    atEntrace = False
                for direction in directions:
                    nR,nC = r + direction[0],c + direction[1]
                    if nR >= 0 and nR < m and nC >= 0 and nC < n:
                        if (nR,nC) not in visited and maze[nR][nC] != "+":
                            q.append([nR,nC])
                            visited.add((nR,nC))
                length -= 1
            distance += 1
        
        return -1


        