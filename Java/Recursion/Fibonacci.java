/*
    Fibonacci Number: https://leetcode.com/problems/fibonacci-number/
    
    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.


    0,1,1,2,3,5,8


*/


class Fibonacci {
    static int count;
    static int fibo(int x) {
        count++;
        System.out.println("calculating for x: " + x);
        if (x==0 || x==1) {
            System.out.println("hit the base case for x: " + x);
            return x;
        }

        int subAns = fibo(x-1) + fibo(x-2);
        System.out.println("calculated for x: " + x + " ans: " + subAns);
        return subAns;
    }

    public static void main(String[] args) {
        int num = 5;
        count = 0;
        int ans = fibo(num);
        System.out.println("fibonacci of " + num + " is: " + ans);
        System.out.println("Number of operations: " + count);
    }
}
