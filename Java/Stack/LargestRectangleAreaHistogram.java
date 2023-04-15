import java.util.*;

class Solution {
    
    public static int[] nsel(int arr[], int n) {
		int ans[] = new int[n];
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < n; i++) {
		    while(!stack.empty() && arr[i] <= arr[stack.peek()]) {
    			stack.pop();
    		}
    		if(stack.empty()) {
    		    ans[i] = -1;
    		} else  {
    		    ans[i] = stack.peek();
    		}
			stack.push(i);
		}
        return ans;
	}

    public static int[] nser(int arr[], int n) {
		int ans[] = new int[n];
		Stack<Integer> stack = new Stack<>();

		for(int i = n - 1; i >= 0; i--) {
		    while(!stack.empty() && arr[i] <= arr[stack.peek()]) {
    			stack.pop();
    		}
    		if(stack.empty()) {
    		    ans[i] = n;
    		} else  {
    		    ans[i] = stack.peek();
    		}
			stack.push(i);
		}
        return ans;
	}

    public int largestRectangleArea(int[] heights) {
        int[] nserIndex = nser(heights, heights.length);
        int[] nselIndex = nsel(heights, heights.length);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (nserIndex[i] - nselIndex[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}