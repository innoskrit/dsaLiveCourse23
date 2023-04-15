#include <bits/stdc++.h> 
using namespace std; 

vector<int> stockSpan(int arr[], int n) {
	stack<int> s;
	vector<int> ans;
	vector<int> span;

	for(int i = 0; i < n; i++) {
	    while(!s.empty() && arr[i] >= arr[s.top()]) {
			s.pop();
		}
		if(s.empty()) {
		    ans.push_back(-1);
		}
		else  {
		    ans.push_back(s.top());
		}
		s.push(i);
	}
	for(int i = 0; i < n; i++) {
		span.push_back(i - ans[i]);
	}
	return span;
}

int main(int argc, char const *argv[]) {
	
	int arr[] = {100, 80, 60, 70, 60, 75, 85}; 
	int n = sizeof(arr) / sizeof(arr[0]); 
	vector<int> ans = stockSpan(arr, n); 
	for (int a: ans) {
		cout << a << " ";
	}

}