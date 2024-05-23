class Solution:
    def toLowerCase(self, s: str) -> str:
        result = ""
        for ch in s:
            if ch.isupper():
                ch = ch.lower()
            result = result + ch
        return result
