/**
 * https://leetcode.com/problems/pancake-sorting/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/pancake-sorting/discuss/214200/Java-flip-the-largest-number-to-the-tail
 */
package com.zea7ot.lc.lvl3.lc0969;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BrutalForce {
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        int len = N;
        for(int i = 0; i < N; i++){
            int index = find(nums, len);
            pancakeFlip(nums, index);
            pancakeFlip(nums, len - 1);
            ans.add(index + 1);
            ans.add(len);
            len--;
        }
        
        return ans;
    }
    
    private int find(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void pancakeFlip(int[] nums, int index){
        int lo = 0, hi = index;
        while(lo < hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}