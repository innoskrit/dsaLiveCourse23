import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            int currFruit = fruits[windowEnd];
            hashMap.put(currFruit, hashMap.getOrDefault(currFruit, 0) + 1);
            while(hashMap.size() > 2) { // invalid window
                int leftFruit = fruits[windowStart];
                hashMap.put(leftFruit, hashMap.get(leftFruit) - 1);
                if(hashMap.get(leftFruit) == 0) {
                    hashMap.remove(leftFruit);
                }
                windowStart += 1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}