class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        count = 0
        for word in words:
            didFail = False
            for ch in word:
                if ch not in allowed:
                    didFail = True
                    break
                    
            if not didFail:
                count += 1

        return count