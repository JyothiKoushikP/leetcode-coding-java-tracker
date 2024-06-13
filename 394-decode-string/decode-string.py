class Solution(object):
    index = 0
    def decodeString(self, s):
        result = ""
        while self.index < len(s) and s[self.index] != ']':
            if not s[self.index].isdigit():
                result += s[self.index]
                self.index += 1
            else:
                k = 0
                while self.index < len(s) and s[self.index].isdigit():
                    k = (k * 10) + (int(s[self.index]))
                    self.index += 1
                self.index += 1
                rem = self.decodeString(s)
                self.index += 1
                while k > 0:
                    result = result + rem
                    k -= 1
        return result