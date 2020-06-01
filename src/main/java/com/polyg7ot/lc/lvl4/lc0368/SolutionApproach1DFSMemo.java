/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(N)
 *  O(N), consumed by the call stack
 * 
 * References:
 *  https://leetcode.com/problems/largest-divisible-subset/discuss/84013/Very-short-Java-DFS-solution-using-Memoization
 */
package com.polyg7ot.lc.lvl4.lc0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach1DFSMemo {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        
        Map<Integer, List<Integer>> memo = new HashMap<Integer, List<Integer>>();
        Arrays.sort(nums);
        return dfs(nums, 0, memo);
    }
    
    private List<Integer> dfs(int[] nums, int i, Map<Integer, List<Integer>> memo){
        if(memo.containsKey(i)) return memo.get(i);
        
        List<Integer> maxLens = new ArrayList<Integer>();
        int div = i == 0 ? 1 : nums[i - 1];
        for(int k = i; k < nums.length; k++){
            if(nums[k] % div == 0){
                // to make a copy here, instead of direct surgery
                List<Integer> list = new ArrayList<Integer>(dfs(nums, k + 1, memo));
                list.add(nums[k]);
                if(list.size() > maxLens.size()){
                    maxLens = list;
                }
            }
        }
        
        memo.put(i, maxLens);
        return maxLens;
    }
}