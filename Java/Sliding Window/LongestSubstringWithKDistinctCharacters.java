import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static int longestSubstring(String s, int k) {

        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currChar = s.charAt(windowEnd);
            hashMap.put(currChar, hashMap.getOrDefault(currChar, 0) + 1);
            while(hashMap.size() > k) { // invalid window
                char leftChar = s.charAt(windowStart);
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                if(hashMap.get(leftChar) == 0) {
                    hashMap.remove(leftChar);
                }
                windowStart += 1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        String s = "aabcddcba";
        int k = 3;
        int ans = LongestSubstringWithKDistinctCharacters.longestSubstring(s, k);
        System.out.println(ans);
    }
}
