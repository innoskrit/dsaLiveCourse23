/*
    Tribonacci Number: https://leetcode.com/problems/n-th-tribonacci-number/
    
    T0 = 0, T1 = 1, T2 = 1, and Tn = Tn-3 + Tn-2 + Tn-1 for n >= 3.
*/


class Tribonacci {
    static int count;
    static int inprogressOperations;
    static int maxCount;
    static int tribo(int x) {
        count++;
        System.out.println("calculating for x: " + x);
        if (x==0 || x==1 || x==2) {
            System.out.println("hit the base case for x: " + x);
            return x;
        }
        inprogressOperations++;
        // worst case space complexity => size of recusive stack
        maxCount = Math.max(inprogressOperations, maxCount);

        int subAns = tribo(x-1) + tribo(x-2) + tribo(x-3);
        System.out.println("calculated for x: " + x + " ans: " + subAns);
        inprogressOperations--;
        return subAns;
    }

    public static void main(String[] args) {
        int num = 5;
        count = 0;
        inprogressOperations = 0;
        maxCount = 0;
        int ans = tribo(num);
        System.out.println("tribonacci of " + num + " is: " + ans);
        System.out.println("Number of operations: " + count);
        System.out.println("Max number of inprogress calculations: " + maxCount);
    }
}