/*
    Fibonacci Number: https://leetcode.com/problems/fibonacci-number/
    
    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.


    0,1,1,2,3,5,8


*/


class Fibonacci {
    static int memo[];
    static int fibo(int x) {
        if (x==0 || x==1) {
            return x;
        }
        if (memo[x] != 0) {
            System.out.println("Returning cached value for x: " + x + " ans: " + memo[x]);
            return memo[x];
        }

        int subAns = fibo(x-1) + fibo(x-2);
        System.out.println("calculated for x: " + x + " ans: " + subAns);
        return memo[x] = subAns;
    }

    public static void main(String[] args) {
        int num = 5;
        memo = new int[num+1];

        int ans = fibo(num);
        System.out.println("fibonacci of " + num + " is: " + ans);
    }
}
