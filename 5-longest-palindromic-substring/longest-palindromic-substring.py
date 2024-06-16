class Solution(object):
    def longestPalindrome(self, s):
        leftIndex, rightIndex = 0,0
        max_length = 0
        for i in range(len(s)):

            # check for odd palindrome
            left, right = i - 1, i + 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            
            if right - left - 1 > max_length:
                max_length = right - left - 1
                leftIndex = left + 1
                rightIndex = right - 1
            
            # check for even palindrome
            if i + 1 < len(s) and s[i] == s[i+1]:
                left, right = i-1,i+2
                while left >= 0 and right < len(s) and s[left] == s[right]:
                    left -= 1
                    right += 1

                if right - left - 1 > max_length:
                    max_length = right - left - 1
                    leftIndex = left + 1
                    rightIndex = right - 1
        
        return s[leftIndex:rightIndex + 1]


        