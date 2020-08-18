/**
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * the approach of preSum applies situations where there are negative numbers.
 * the approach below requires only 1 pass of the array.
 * 
 * Reference:   
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685470/Python-One-pass-prefix-sum-O(n)/578264
 *  https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685470/Python-One-pass-prefix-sum-O(n)
 */
package com.zea7ot.leetcode.lvl4.lc1477;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PreSum {
    public int minSumOfLengths(int[] nums, int target) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, -1);
        
        final int N = nums.length;
        int[] minLens = new int[N];
        Arrays.fill(minLens, Integer.MAX_VALUE);
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++){
            sum += nums[i];
            int key = sum - target;
            if(preSum.containsKey(key)){
                int prevIdx = preSum.get(key);
                if(prevIdx > -1 && minLens[prevIdx] != Integer.MAX_VALUE){
                    ans = Math.min(ans, i - prevIdx + minLens[prevIdx]);
                }
                minLen = Math.min(minLen, i - prevIdx);
            }
            
            minLens[i] = minLen;
            preSum.put(sum, i);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}