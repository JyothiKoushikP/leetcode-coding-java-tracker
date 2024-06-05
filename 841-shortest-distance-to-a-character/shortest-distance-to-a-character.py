class Solution(object):
    def shortestToChar(self, s, c):
        track = []
        for i in range(len(s)):
            if s[i] == c:
                track.append(i)
        
        result = [0] * len(s)
        left, right = -1, 0
        for i in range(len(s)):
            if s[i] == c:
                result[i] = 0
                left += 1
                right += 1 
            elif left == -1:
                result[i] = track[right] - i
            else:
                if right == len(track):
                    result[i] = i - track[left]
                else:
                    result[i] = min(track[right] - i,i - track[left])
        
        return result