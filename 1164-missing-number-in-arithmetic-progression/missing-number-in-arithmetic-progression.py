class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        n = len(arr)
        difference = int((arr[n-1] - arr[0]) / n)
        expected = arr[0]
        for i in range(n):
            if not expected == arr[i]:
                return expected
            expected += difference
        return expected