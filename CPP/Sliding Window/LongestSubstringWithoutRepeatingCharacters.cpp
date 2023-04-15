class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int windowStart = 0;
        int maxLength = 0;
        map<char, int> hashMap;

        for(int windowEnd = 0; windowEnd < s.size(); windowEnd++) {
            char currChar = s[windowEnd];
            hashMap[currChar] += 1;
            while(hashMap.size() != (windowEnd - windowStart + 1)) {
                char leftChar = s[windowStart];
                hashMap[leftChar] -= 1;
                if(hashMap[leftChar] == 0) {
                    hashMap.erase(leftChar);
                }
                windowStart += 1;
            }
            maxLength = max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
};