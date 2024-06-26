class Solution(object):
    def minInsertions(self, s):
        """
        :type s: str
        :rtype: int
        """
        m = s.replace("))","*")
        stack = []
        total = 0
        for c in m:
            if c == '*':
                if len(stack) == 0:
                    total += 1
                else:
                    stack.pop()
            elif c == '(':
                stack.append(c)
            elif c == ')':
                total += 1
                if len(stack) == 0:
                    total += 1
                else:
                    stack.pop()
        
        total += (2 * len(stack))

        return total
            


        