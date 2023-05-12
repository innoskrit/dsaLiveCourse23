/*
    Tribonacci Number: https://leetcode.com/problems/n-th-tribonacci-number/
    
    T0 = 0, T1 = 1, T2 = 1, and Tn = Tn-3 + Tn-2 + Tn-1 for n >= 3.
*/


class Tribonacci {
    static int count;
    static int tribo(int x) {
        count++;
        System.out.println("calculating for x: " + x);
        if (x==0 || x==1 || x==2) {
            System.out.println("hit the base case for x: " + x);
            return x;
        }

        int subAns = tribo(x-1) + tribo(x-2) + tribo(x-3);
        System.out.println("calculated for x: " + x + " ans: " + subAns);
        return subAns;
    }

    public static void main(String[] args) {
        int num = 5;
        count = 0;
        int ans = tribo(num);
        System.out.println("tribonacci of " + num + " is: " + ans);
        System.out.println("Number of operations: " + count);
    }
}

/*
    Operations: 3^(n-2)-1 = 

*/