class Solution(object):
    index = 0
    def scoreOfParentheses(self, s):
        total_score = 0
        while self.index < len(s) and s[self.index] != ')':
            if s[self.index] == '(':
                self.index += 1
                score = self.scoreOfParentheses(s)
                if score == 0:
                    total_score += 1
                else:
                    total_score += (2 * score)
                self.index += 1
        return total_score
        