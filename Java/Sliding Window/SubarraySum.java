class Subarray {

    public static int[] subarraySum(int arr[], int k) {
        int ans[] = new int[arr.length - k + 1]; // created answer

        int windowSum = 0, windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1) {
                ans[windowStart] = windowSum;
                windowSum -= arr[windowStart];
                windowStart += 1;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4, 6, 2, 3, 1, 9};
        int k = 3;
        int ans[] = Subarray.subarraySum(arr, k);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}