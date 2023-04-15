class LongestSubstringWithKDistinctCharacters:
    def longestSubstring(self, s, k):
        windowStart = 0
        maxLength = 0
        hashMap = dict()

        for windowEnd in range(len(s)):
            currChar = s[windowEnd]
            hashMap[currChar] = hashMap.get(currChar, 0) + 1
            while(len(hashMap) > k):
                leftChar = s[windowStart]
                hashMap[leftChar] -= 1
                if(hashMap[leftChar] == 0):
                    del hashMap[leftChar]
                windowStart += 1
            maxLength = max(maxLength, windowEnd - windowStart + 1)
        
        return maxLength

if __name__ == '__main__':
    s = "aabcddcba"
    k = 3
    ans = LongestSubstringWithKDistinctCharacters().longestSubstring(s, k)
    print(ans)