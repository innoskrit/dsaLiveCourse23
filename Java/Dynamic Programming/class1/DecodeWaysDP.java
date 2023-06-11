/*
    Recurrance Relation: 
        NumWays(s,i) = Numways(s,i+1) + NumWays(s,i+2)
        Conditions for early pruning 
            - if s(i) is 0 then prune
            - if substring(i,i+2) > 26 then prune for i+2 case

    Base case:
        If string can successfully be decoded then number of ways is 1
    Leetcode: https://leetcode.com/problems/decode-ways/
*/

import java.util.*;
class DecodeWaysMemo {
    static public int decodeWays(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
               dp[i] = dp[i - 1];  
            }
            
            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "121"; // (1, 21), (12, 1), (1,2,1)
        // String s = "12131";
        int ans = decodeWays(s);
        System.out.println("Number of ways to decode: " + s + " are: " + ans);
    }
}