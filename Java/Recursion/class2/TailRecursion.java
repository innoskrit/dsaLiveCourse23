class TailRecursion {

    static int factorial(int x, int a) {
        System.out.println("calculating for x: " + x);
        if (x<=0) {
            System.out.println("hit the base case for x: " + x);
            return a;
        }

        return factorial(x-1, x*a);
    }

    public static void main(String[] args) {
        int num = 5;
        int ans = factorial(num, 1);
        System.out.println("factorial of " + num + " is: " + ans);
    }
}