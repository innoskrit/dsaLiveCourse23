/*
    Leetcode: https://leetcode.com/problems/climbing-stairs/

    Recurrance Relation: 
        Ways(i,n) = Ways(i+1,n) + Ways(i+2, n)
    Base case:
        if i == n, able to climb then
    Example:-
        n = 3
        ways:
            1,1,1
            1,2
            2,1
*/

import java.util.*;

class ClimbingStairsMemo {
    static int climbStairs(int n) {
        if(n==1) {
            return 1;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int ans = climbStairs(20);
        System.out.println("Number of ways to reach on top are: " + ans);
    }
}
