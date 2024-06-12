class Solution(object):
    def candy(self, ratings):
        candies = [1] * len(ratings)
        for i in range(len(ratings)):
            if i-1 < 0:
                continue
            elif ratings[i-1] < ratings[i]:
                    if candies[i] <= candies[i-1]:
                        candies[i] = candies[i-1] + 1

        for i in range(len(ratings)-1,-1,-1):
            if i+1 >= len(ratings):
                continue
            elif ratings[i] > ratings[i+1]:
                if candies[i] <= candies[i+1]:
                    candies[i] = candies[i+1] + 1

        return sum(candies)
