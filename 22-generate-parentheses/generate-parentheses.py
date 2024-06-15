class Solution(object):
    def generateParenthesis(self, n):
        result = []
        open,closed,balance = n,n,0
        s = ""
        self.recursive_generation(s,open,closed,balance,result)
        return result
    
    def recursive_generation(self, s, open, closed, balance,result):
        if open == 0 and closed == 0:
            result.append(s)
            return
        
        if open == 0:
            self.recursive_generation(s + ")",open,closed - 1,balance - 1,result)
        elif balance == 0:
            self.recursive_generation(s + "(",open - 1,closed,balance + 1,result)
        else:
            self.recursive_generation(s + "(",open - 1,closed,balance + 1,result)
            self.recursive_generation(s + ")",open,closed -1,balance - 1,result)

        return 