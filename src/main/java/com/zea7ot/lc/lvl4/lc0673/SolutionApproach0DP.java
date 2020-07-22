/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107318/C%2B%2B-DP-with-explanation-O(n2)
 */
package com.zea7ot.lc.lvl4.lc0673;

import java.util.Arrays;

public class SolutionApproach0DP {
    public int findNumberOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int[] lens = new int[N];
        Arrays.fill(lens, 1);
        int[] counts = new int[N];
        Arrays.fill(counts, 1);
        
        int maxLen = 0, ans = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(lens[i] == lens[j] + 1) {
                        counts[i] += counts[j];
                    }else if(lens[i] < lens[j] + 1){
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, lens[i]);
        }
        
        for(int i = 0; i < N; i++){
            if(lens[i] == maxLen){
                ans += counts[i];
            }
        }
        
        return ans;
    }
}