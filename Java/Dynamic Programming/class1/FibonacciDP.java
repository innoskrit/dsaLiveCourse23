/*
    Fibonacci Number: https://leetcode.com/problems/fibonacci-number/
    
    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.


    0,1,1,2,3,5,8


*/


class Fibonacci {
    static int fibo(int x) {
        int dp[] = new int[x+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=x;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[x];
    }

    public static void main(String[] args) {
        int num = 5;

        int ans = fibo(num);
        System.out.println("fibonacci of " + num + " is: " + ans);
    }
}
