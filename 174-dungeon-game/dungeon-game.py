class Solution(object):
    def calculateMinimumHP(self, dungeon):
        rows, columns = len(dungeon), len(dungeon[0])
        
        dp = [[0] * columns for i in range(rows)]

        if dungeon[rows-1][columns - 1] <= 0:
            dp[rows-1][columns-1] = (dungeon[rows-1][columns - 1] * -1) + 1
        else:
            dp[rows-1][columns-1] = 1
        
        for i in range(columns-2,-1,-1):
            ele = dungeon[rows-1][i]
            
            if ele > 0:
                if dp[rows-1][i+1] <= ele:
                    dp[rows-1][i] = 1
                else:
                    dp[rows-1][i] = dp[rows-1][i+1] - ele
            else:
                dp[rows-1][i] = dp[rows-1][i+1] - ele
        
        for i in range(rows-2,-1,-1):
            ele = dungeon[i][columns-1]

            if ele > 0:
                if dp[i+1][columns-1] <= ele:
                    dp[i][columns-1] = 1
                else:
                    dp[i][columns-1] = dp[i+1][columns-1] - ele
            else:
                dp[i][columns-1] = dp[i+1][columns-1] - ele

        for i in range(rows-2,-1,-1):
            for j in range(columns-2,-1,-1):
                ele = dungeon[i][j]

                down = dp[i+1][j]
                right = dp[i][j+1]

                if ele > 0:
                    if down <= ele:
                        down = 1
                    else:
                        down = down - ele
                    
                    if right <= ele:
                        right = 1
                    else:
                        right = right - ele

                    dp[i][j] = min(down,right)
                else:
                    down = down - ele
                    right = right - ele
                    dp[i][j] = min(down,right)
        
        return dp[0][0]