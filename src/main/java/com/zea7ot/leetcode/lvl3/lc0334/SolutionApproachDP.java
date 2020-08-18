/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0334;

public class SolutionApproachDP {
    public boolean increasingTriplet(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums){
            int left = 0, right = size;
            while(left < right){
                int mid = left + (right - left) / 2;
                if(tails[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            tails[left] = num;
            if(left == size){
                ++size;
                if(size >= 3) return true;
            }
        }
        
        return false;
    }
}