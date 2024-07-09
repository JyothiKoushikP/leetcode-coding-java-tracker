
class Solution(object):
    MOD = 10**9 + 7
    def knightDialer(self, n):
        if n == 1: return 10
        dirs = [[-2,-1],[-2,1],[2,-1],[2,1],[-1,-2],[-1,2],[1,-2],[1,2]]
        phonepad = [["1","2","3"],["4","5","6"],["7","8","9"],["*","0","#"]]
        digit_mappings = {}

        for i in range(len(phonepad)):
            for j in range(len(phonepad[i])):
                if phonepad[i][j].isdigit():
                    digit_mappings[phonepad[i][j]] = []
                    for direction in dirs:
                        nR,nC = i + direction[0],j + direction[1]
                        if nR >= 0 and nR < len(phonepad) and nC >= 0 and nC < len(phonepad[0]):
                            if phonepad[nR][nC].isdigit():
                                digit_mappings[phonepad[i][j]].append(phonepad[nR][nC])

        dp = [[0] * 10 for i in range(n)]

        dp[0] = [1] * 10

        for digit in digit_mappings.keys():
            dp[1][int(digit)] = len(digit_mappings[digit])

        for i in range(2,len(dp)):
            for j in range(0,10):
                s = str(j)
                total_sum = 0
                for d in digit_mappings[s]:
                    total_sum = (total_sum + dp[i-1][int(d)]) % Solution.MOD
                dp[i][j] = total_sum
        
        total_sum = 0
        for i in dp[n-1]:
            total_sum = (total_sum + i) % Solution.MOD
        
        return total_sum

        




