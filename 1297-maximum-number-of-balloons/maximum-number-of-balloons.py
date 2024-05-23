import math

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        b = "balloon"
        freq = [0] * 26
        for ch in text:
            freq[ord(ch) - ord('a')] += 1
        minChar = math.inf
        for ch in b:
            frequency = freq[ord(ch) - ord('a')]
            if ch == 'l' or ch == 'o':
                minChar = min(int(frequency / 2), minChar)
            else:
                minChar = min(int(frequency), minChar)

        return minChar
