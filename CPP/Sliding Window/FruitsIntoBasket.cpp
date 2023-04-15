class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int windowStart = 0;
        int maxLength = 0;
        map<int, int> hashMap;

        for(int windowEnd = 0; windowEnd < fruits.size(); windowEnd++) {
            int currFruit = fruits[windowEnd];
            hashMap[currFruit] += 1;
            while(hashMap.size() > 2) { // invalid window
                int leftFruit = fruits[windowStart];
                hashMap[leftFruit] -= 1;
                if(hashMap[leftFruit] == 0) {
                    hashMap.erase(leftFruit);
                }
                windowStart += 1;
            }
            maxLength = max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
};