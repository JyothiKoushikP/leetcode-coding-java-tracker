class Solution(object):
    def intervalIntersection(self, firstList, secondList):
        result = []
        i,j,m,n = 0,0,len(firstList),len(secondList)
        while i < m and j < n:
            starti, endi = firstList[i]
            startj, endj = secondList[j]

            if endi == endj:
                if starti < startj:
                    result.append([startj,endi])
                    j += 1
                else:
                    result.append([starti,endi])
                    i += 1

            elif endi >= startj and endi <= endj:
                if starti < startj:
                    result.append([startj,endi])
                else:
                    result.append([starti,endi])
                i += 1
            elif endj >= starti and endj <= endi:
                if startj < starti:
                    result.append([starti,endj])
                else:
                    result.append([startj,endj])
                j += 1
            else:
                if starti < startj:
                    i += 1
                else:
                    j += 1
        
        return result
        

        