class Solution:
    def compress(self, chars: List[str]) -> int:
        i = 0
        startIndex = 0
        while i < len(chars):
            count = 0
            ch = chars[i]
            index = i
            while index < len(chars) and chars[index] == ch:
                count += 1
                index += 1
            chars[startIndex] = ch
            startIndex += 1
            if count > 1:
                for num in str(count):
                    chars[startIndex] = num
                    startIndex += 1
            i = index
        return startIndex

        
        return