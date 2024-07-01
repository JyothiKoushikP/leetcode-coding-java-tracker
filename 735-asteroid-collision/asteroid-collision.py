class Solution(object):
    def asteroidCollision(self, asteroids):
        stack = []
        for i in asteroids:
            if len(stack) == 0:
                stack.append(i)
            else:
                shouldInsert = True
                while len(stack) > 0 and (self.isPositive(stack[-1]) and not self.isPositive(i)):
                    if abs(stack[-1]) < abs(i):
                        stack.pop()
                    elif abs(stack[-1]) == abs(i):
                        shouldInsert = False
                        stack.pop()
                        break
                    else:
                        shouldInsert = False
                        break
                    
                if shouldInsert:
                    stack.append(i)
                
        return stack

    def isPositive(self,num):
        return True if (num * 1) > 0 else False
        