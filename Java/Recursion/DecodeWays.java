class DecodeWays {
    static int decodeWaysUtil(String s, int i) {
        if (s.length() == i) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }
        int ones = decodeWaysUtil(s, i+1);
        int twos = 0;
        if (i+1 < s.length() && (Integer.parseInt(s.substring(i, i+2)) <= 26)) {
            twos = decodeWaysUtil(s, i+2);
        }

        return ones+twos;
    }

    static int decodeWays(String s) {
        return decodeWaysUtil(s, 0);
    }

    public static void main(String[] args) {
        // String s = "12";
        String s = "226"; // (2,2,6), (22,6), (2,26)
        int ans = decodeWays(s);
        System.out.println("Number of ways to decode: " + s + " are: " + ans);
    }
}