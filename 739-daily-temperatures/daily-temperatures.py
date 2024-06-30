class Solution(object):
    def dailyTemperatures(self, temperatures):
        result = [0] * len(temperatures)
        stack = []
        stack.append([temperatures[len(temperatures)-1],len(temperatures)-1])
        for i in range(len(result)-2,-1,-1):
            while len(stack) > 0 and stack[-1][0] <= temperatures[i]:
                stack.pop()
            if len(stack) == 0:
                result[i] = 0
            else:
                result[i] = stack[-1][1] - i
            stack.append([temperatures[i],i])
        
        return result
        