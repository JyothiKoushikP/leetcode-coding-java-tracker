from collections import deque
class Solution(object):
    def minimumOperationsToMakeEqual(self, x, y):
        visited = set()
        q = deque()
        distance = 0
        q.append(x)
        visited.add(x)
        while len(q) > 0:
            length = len(q)
            while length > 0:
                curr = q.popleft()

                if curr == y:
                    return distance

                if curr % 5 == 0:
                    if curr / 5 not in visited:
                        q.append(curr / 5)
                        visited.add(curr / 5)
                
                if curr % 11 == 0:
                    if curr / 11 not in visited:
                        q.append(curr / 11)
                        visited.add(curr / 11)
                
                if curr - 1 not in visited:
                    q.append(curr-1)
                    visited.add(curr-1)

                if curr + 1 not in visited:
                    q.append(curr + 1)
                    visited.add(curr + 1)
                length = length - 1       
            distance += 1
            