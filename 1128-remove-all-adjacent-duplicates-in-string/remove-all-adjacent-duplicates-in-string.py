class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []
        result = ""
        for ch in s:
            if len(stack) == 0 or stack[-1] != ch:
                stack.append(ch)
            else:
                stack.pop()
        
        for ch in stack:
            result += ch
        
        return result