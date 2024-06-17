class Solution(object):
    def characterReplacement(self, s, k):
        map = {}
        left, max_length, max_frequency = 0, 0, 0
        for right in range(len(s)):
            c = s[right]
            map[c] = map.get(c,0) + 1
            max_frequency = max(max_frequency,map[c])

            length = right - left + 1
            if length - max_frequency > k:
                ch = s[left]
                if map[ch] == 1:
                    map.pop(ch)
                else:
                    map[ch] = map[ch] - 1
                left += 1
            max_length = max(max_length,right - left + 1)

        return max_length
        