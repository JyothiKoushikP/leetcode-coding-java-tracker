class NumArray:

    def __init__(self, nums: List[int]):
        self.prefixArray = nums
        sum = self.prefixArray[0]
        for i in range(1, len(self.prefixArray)):
            sum += self.prefixArray[i]
            self.prefixArray[i] = sum


    def sumRange(self, left: int, right: int) -> int:
        if left == 0:
            return self.prefixArray[right]
        else:
            return self.prefixArray[right] - self.prefixArray[left - 1]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)