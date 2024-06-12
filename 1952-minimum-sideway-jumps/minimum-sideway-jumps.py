'''
If you get obstacle, pick the lane with the farthest obstacle
Greedy: picking up the lane with the farthest which can take us to the destination
with minimum jumps
'''

class Solution(object):
    def minSideJumps(self, obstacles):
        """
        :type obstacles: List[int]
        :rtype: int
        """
        frog = 2
        jumps = 0
        index = 0

        while index < len(obstacles):
            l1, l2 = index, index

            if index + 1 < len(obstacles) and obstacles[index + 1] == frog:
                jumps += 1
                f1, f2 = 0,0
                if frog == 1:
                    f1, f2 = 2,3
                elif frog == 2:
                    f1, f2 = 1,3
                elif frog == 3:
                    f1, f2 = 1,2
                
                o1 = o2 = False
                while l1 < len(obstacles) and l2 < len(obstacles) and not (o1 and o2):
                    if obstacles[l1] == f1:
                        o1 = True
                    if obstacles[l2] == f2:
                        o2 = True

                    l1 += 1 if not o1 else 0
                    l2 += 1 if not o2 else 0
                
                frog = f1 if l1 > l2 else f2
                r = max(l1 -1,l2 -1)
            else:
                index += 1
        

        return jumps



                    


            
        