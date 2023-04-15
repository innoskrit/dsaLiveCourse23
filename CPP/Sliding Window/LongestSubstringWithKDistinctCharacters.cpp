class LongestSubstringWithKDistinctCharacters {
public:
    static int longestSubstring(string s, int k) {
        int windowStart = 0;
        int maxLength = 0;
        map<char, int> hashMap;

        for(int windowEnd = 0; windowEnd < s.size(); windowEnd++) {
            char currChar = s[windowEnd];
            // hashMap.put(currChar, hashMap.getOrDefault(currChar, 0) + 1);
            hashMap[currChar] += 1;
            while(hashMap.size() > k) { // invalid window
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

int main(int argc, char const *argv[]) {
    string s = "aabcddcba";
    int k = 3;
    int ans = LongestSubstringWithKDistinctCharacters::longestSubstring(s, k);
    cout << ans << endl;
    return 0;
}
