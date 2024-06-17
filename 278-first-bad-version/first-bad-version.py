# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        bad_version = -1
        start, end = 1, n
        while start <= end:
            mid = start + (end - start) / 2
            if not isBadVersion(mid):
                start = mid + 1
            else:
                bad_version = mid
                end = mid - 1
        return bad_version

        