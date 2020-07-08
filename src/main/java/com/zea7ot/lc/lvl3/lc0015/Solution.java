/**
 * https://leetcode.com/problems/3sum
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;

        final int N = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < N - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            int j = i + 1, k = N - 1;
            int target = -nums[i];
            
            while(j < k){
                if(nums[j] + nums[k] == target){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }else if(nums[j] + nums[k] > target) k--;
                else j++;
            }
        }
        
        return ans;
    }
}