class Recursion {
    static int memo[];
    static int factorial(int x) {
        if (x==0 || x==1) {
            System.out.println("hit the base case for x: " + x);
            return x;
        }
        if (memo[x] != 0) {
            System.out.println("Returning cached value for x: " + x + " ans: " + memo[x]);
            return memo[x];
        }

        memo[x] = x*factorial(x-1);
        System.out.println("calculated for x: " + x + " ans: " + memo[x]);

        return memo[x];
    }

    public static void main(String[] args) {
        int num = 5;
        memo = new int[num+1];
        int ans = factorial(num);
        System.out.println("factorial of " + num + " is: " + ans);
    }
}