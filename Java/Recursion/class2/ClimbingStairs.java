/*
    Leetcode: https://leetcode.com/problems/climbing-stairs/

    Recurrance Relation: 
        Ways(i,n) = Ways(i+1,n) + Ways(i+2, n)
    Base case:
        if i == n, able to climb then
*/

class ClimbingStairs {
    static int count;
    static int inprogressOperations;
    static int maxCount;
    static int climbStairsUtil(int i, int n) {
        count++;
        if(i==n || i==n-1) {
            return 1;
        }
        inprogressOperations++;
        maxCount = Math.max(inprogressOperations, maxCount);

        int oneStep = climbStairsUtil(i+1, n);
        int twoStep = climbStairsUtil(i+2, n);

        inprogressOperations--;

        return oneStep + twoStep;
    }

    static int climbStairs(int n) {
        return climbStairsUtil(0, n);
    }

    public static void main(String[] args) {
        count = 0;
        inprogressOperations = 0;
        maxCount = 0;
        int ans = climbStairs(5);
        /*
            1,1,1
            1,2
            2,1
        */
        System.out.println("Number of ways to reach on top are: " + ans);
        System.out.println("Number of operations: " + count);
        System.out.println("Max number of inprogress calculations: " + maxCount);
    }
}
