class Solution(object):
    def smallestSubsequence(self, s):
        result = ""
        freq = {}
        stack = []
        unique_set = set()
        for c in s:
            freq[c] = freq.get(c,0) + 1
        unique_characters = len(freq)
        for c in s:
            if c not in unique_set:
                while(len(stack) > 0 and stack[-1] > c):
                    if stack[-1] in freq:
                        ch = stack.pop()
                        unique_set.remove(ch)
                    else:
                        break
                stack.append(c)
                unique_set.add(c)
            if freq[c] == 1:
                freq.pop(c)
            else:
                freq[c] = freq[c] - 1
                    
        return "".join(stack)
        