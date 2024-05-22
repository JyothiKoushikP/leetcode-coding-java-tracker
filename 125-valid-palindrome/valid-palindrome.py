class Solution:
    def isPalindrome(self, s: str) -> bool:
        pointer1 = 0
        pointer2 = len(s) - 1
        while pointer1 < pointer2:
            start = s[pointer1]
            end = s[pointer2]

            if not (start.isalpha() or start.isdigit()):
                pointer1 += 1
                continue

            if not (end.isalpha() or end.isdigit()):
                pointer2 -= 1
                continue

            start = start.lower() if start.isalpha() else start
            end = end.lower() if end.isalpha() else end

            if start != end:
                return False
            pointer1 += 1
            pointer2 -= 1

        return True       