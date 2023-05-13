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

class DecodeWays {
    static int count;
    static int inprogressOperations;
    static int maxCount;
    static int decodeWaysUtil(String s, int i) {
        count++;
        System.out.println("calculating for index: " + i);
        if (s.length() == i) {
            System.out.println("hit the base case for index: " + i);
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }
        inprogressOperations++;
        // worst case space complexity => size of recusive stack
        maxCount = Math.max(inprogressOperations, maxCount);
        int ones = decodeWaysUtil(s, i+1);
        int twos = 0;
        if (i+1 < s.length() && (Integer.parseInt(s.substring(i, i+2)) <= 26)) {
            twos = decodeWaysUtil(s, i+2);
        }
        System.out.println("calculated for index: " + i + " ans: " + (ones+twos));
        inprogressOperations--;

        return ones+twos;
    }

    static int decodeWays(String s) {
        return decodeWaysUtil(s, 0);
    }

    public static void main(String[] args) {
        String s = "121";
        // String s = "12131"; // (2,2,6), (22,6), (2,26)
        count = 0;
        inprogressOperations = 0;
        maxCount = 0;
        int ans = decodeWays(s);
        System.out.println("Number of ways to decode: " + s + " are: " + ans);
        System.out.println("Number of operations: " + count);
        System.out.println("Max number of inprogress calculations: " + maxCount);
    }
}