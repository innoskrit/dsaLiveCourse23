class Recursion {

    static int factorial(int x) {
        System.out.println("calculating for x: " + x);
        if (x==0 || x==1) {
            System.out.println("hit the base case for x: " + x);
            return x;
        }

        int subAns = factorial(x-1);
        System.out.println("calculated for x: " + x + " ans: " + subAns);
        return x*subAns;
    }

    public static void main(String[] args) {
        int num = 5;
        int ans = factorial(num);
        System.out.println("factorial of " + num + " is: " + ans);
    }
}