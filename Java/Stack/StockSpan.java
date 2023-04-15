import java.util.*; 

class StockSpan {

	public static List<Integer> stockSpan(int arr[], int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for(int i = 0; i < n; i++) {
		    while(!stack.empty() && arr[i] >= arr[stack.peek()]) {
    			stack.pop();
    		}
    		if(stack.empty()) {
    		    ans.add(-1);
    		} else  {
    		    ans.add(stack.peek());
    		}
			stack.push(i);
		}
        List<Integer> span = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            span.add(i - ans.get(i));
        }
		return span;
	}

	public static void main(String[] args) {
		
		int arr[] = {100, 80, 60, 70, 60, 75, 85}; 
		List<Integer> ans = stockSpan(arr, arr.length); 
		System.out.println(ans.toString());

	}
}