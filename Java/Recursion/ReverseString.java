class ReverseString {

    static void reverseStringUtil(char[] str, int i, int j) {
        if (i>=j) {
            return;
        }

        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;

        reverseStringUtil(str, i+1,j-1);
    }

    static String reverseString(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        char[] str = s.toCharArray();

        reverseStringUtil(str, 0, str.length-1);
        return new String(str);
    }

    public static void main(String[] args) {
        String str = "abhishek";
        String ans = reverseString(str);
        System.out.println("Original string: " + str + " reversed string: " + ans);
    }
}
