class Solution(object):
    def findPermutationDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        indexMap = {}
        for i in range(0,len(s)):
            indexMap[s[i]] = i
        sum = 0
        for i in range(0,len(t)):
            sum += abs(i - indexMap[t[i]])
        return sum