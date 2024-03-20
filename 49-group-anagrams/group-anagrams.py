class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        track = collections.defaultdict(list)
        for s in strs:
            freq = [0] * 26
            for c in s:
                freq[ord(c) - ord('a')] += 1
            track[tuple(freq)].append(s);
        return list(track.values())
        