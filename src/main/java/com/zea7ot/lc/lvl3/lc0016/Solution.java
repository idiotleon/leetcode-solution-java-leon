/**
 * https://leetcode.com/problems/3sum-closest/
 * 
 * Time Complexity:     O(N ^ 2) + O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0016;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int ans = nums[0] + nums[1] + nums[N - 1];
        Arrays.sort(nums);
        for(int i = 0; i < N - 2; i++){
            int start = i + 1, end = N - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target) end--;
                else start++;
                
                if(Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
            }
        }
        
        return ans;
    }
} 