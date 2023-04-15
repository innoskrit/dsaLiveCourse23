#include <iostream>
#include <vector>
using namespace std;

vector<int> subarraySum(vector<int>& arr, int k) {
    vector<int> ans(arr.size() - k + 1); // created answer

    int windowSum = 0;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
        windowSum += arr[windowEnd];
        if(windowEnd >= k - 1) {
            ans[windowStart] = windowSum;
            windowSum -= arr[windowStart];
            windowStart += 1;
        }
    }
    
    return ans;
}

int main() {
    vector<int> arr{4, 6, 2, 3, 1, 9};
    int k = 3;
    vector<int> ans = subarraySum(arr, k);
    for(int n : ans) {
        cout << n << " ";
    }
    return 0;
}
