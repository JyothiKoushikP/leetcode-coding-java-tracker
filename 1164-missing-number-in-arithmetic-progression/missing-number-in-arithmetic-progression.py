class Solution:
    def missingNumber(self, arr: List[int]) -> int:
        n = len(arr)
        difference = int((arr[n-1] - arr[0]) / n)
        start, end = 0, n-1
        while start < end:
            mid = int(start + (end - start) / 2);
            if arr[mid] == (arr[0] + (mid * difference)):
                start = mid + 1
            else:
                end = mid;
        return arr[0] + (start * difference)