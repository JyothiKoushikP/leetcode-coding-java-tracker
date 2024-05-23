class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip(' ')
        end, count = len(s) - 1, 0
        while end >= 0 and s[end] != ' ':
            count += 1
            end -= 1
        return count