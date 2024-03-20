class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        track = {}
        for i in range(len(strs)):
            freq = [0] * 26
            for j in range(0,len(strs[i])):
                index = ord(strs[i][j]) - ord('a')
                freq[index] += 1
            freqString = ""
            for j in range(0,len(freq)):
                freqString += str(freq[j])
                freqString += "#"
            if not freqString in track:
                track[freqString] = []
            track[freqString].append(strs[i])
        return list(track.values())
        