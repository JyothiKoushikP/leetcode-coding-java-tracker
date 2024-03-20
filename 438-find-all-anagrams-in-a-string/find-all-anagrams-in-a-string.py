

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        pCount = [0] * 26
        sCount = [0] * 26
        k = len(p)

        for c in p:
            pCount[ord(c) - ord('a')] += 1
        
        left = 0
        for right in range(len(s)):
            sCount[ord(s[right]) - ord('a')] += 1

            if right - left + 1 == k:
                if pCount == sCount:
                    result.append(left)
                sCount[ord(s[left]) - ord('a')] -= 1;
                left += 1
            
        return result;

