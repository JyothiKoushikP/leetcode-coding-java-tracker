class Solution(object):
    def longestCommonPrefix(self, strs):
        prefix = strs[0]
        for i in range(1,len(strs)):
            curr = strs[i]
            while not curr.startswith(prefix):
                prefix = prefix[:len(prefix) - 1]

        return prefix
        