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
    static HashMap<Integer, Integer> cache;
    static int climbStairsUtil(int i, int n) {
        if(i==n || i==n-1) {
            return 1;
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        int oneStep = climbStairsUtil(i+1, n);
        int twoStep = climbStairsUtil(i+2, n);
        cache.put(i, oneStep+twoStep);

        return oneStep + twoStep;
    }

    static int climbStairs(int n) {
        cache = new HashMap<>();
        return climbStairsUtil(0, n);
    }

    public static void main(String[] args) {
        int ans = climbStairs(20);
        System.out.println("Number of ways to reach on top are: " + ans);
    }
}
