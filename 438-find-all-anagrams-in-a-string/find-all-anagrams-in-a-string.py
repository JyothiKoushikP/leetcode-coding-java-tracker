class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result = []
        pCount = collections.defaultdict(int)
        sCount = collections.defaultdict(int)
        left = 0;
        k = len(p)
        
        for c in p:
            pCount[c] += 1

        for right in range(0,len(s)):
            sCount[s[right]] += 1
            if(right - left + 1 == k):

                if pCount == sCount:
                    result.append(left)

                if sCount[s[left]] == 1:
                    del sCount[s[left]]
                else:
                    sCount[s[left]] -= 1

                left += 1
        return result
