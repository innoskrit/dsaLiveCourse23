/*
    # Backtracking
    Recurrance Relation: 
        For every possible size
            - 2 choices
                - Pick element
                - Skip element
       
    Base case:
        Size is equal to subset size
        
    Leetcode: https://leetcode.com/problems/subsets/
*/

import java.util.*;
class Subsets {
    static List<List<Integer>> ans;

    static void backTrack(int first, int[] nums, int k, List<Integer> curr) {
        if(curr.size()==k) {
            System.out.println("reached base case");
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=first;i<nums.length;i++) {
            System.out.println("Adding: " + nums[i]);
            curr.add(nums[i]);

            backTrack(i+1, nums, k, curr);

            System.out.println("Deleting: " + curr.get(curr.size()-1));
            curr.remove(curr.size()-1);
        }
    }

    static List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        for(int k=0;k<=nums.length;k++) {
            System.out.println("Starting backTracking for subset of size: " + k);
            backTrack(0, nums, k, new ArrayList<Integer>());
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> output = subsets(nums);
        System.out.println("Subsets: ");
        for(List<Integer> subset: output) {
            for(int num: subset) {
                System.out.printf(num + " ");
            }
            System.out.println();
        }
    }
}