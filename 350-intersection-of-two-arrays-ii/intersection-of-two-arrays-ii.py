class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) >= len(nums2):
            return self.getCommonList(nums2, nums1)
        else:
            return self.getCommonList(nums1, nums2)

    def getCommonList(self, small, big):
        small.sort()
        big.sort()
        result = []
        m, n = 0, 0
        while m < len(big) and n < len(small):
            if big[m] < small[n]:
                m += 1
            elif big[m] > small[n]:
                n += 1
            else:
                result.append(big[m])
                m += 1
                n += 1
        return result
