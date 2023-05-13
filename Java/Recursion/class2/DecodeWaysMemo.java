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
    static HashMap<Integer, Integer> cache;
    static int decodeWaysUtil(String s, int i) {
        if (s.length() == i) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        int ones = decodeWaysUtil(s, i+1);
        int twos = 0;
        if (i+1 < s.length() && (Integer.parseInt(s.substring(i, i+2)) <= 26)) {
            twos = decodeWaysUtil(s, i+2);
        }
        cache.put(i, ones+twos);

        return ones+twos;
    }

    static int decodeWays(String s) {
        cache = new HashMap<>();
        return decodeWaysUtil(s, 0);
    }

    public static void main(String[] args) {
        String s = "121"; // (1, 21), (12, 1), (1,2,1)
        // String s = "12131";
        int ans = decodeWays(s);
        System.out.println("Number of ways to decode: " + s + " are: " + ans);
    }
}