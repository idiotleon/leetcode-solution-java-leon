/**
 * https://leetcode.com/problems/get-the-maximum-score/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/get-the-maximum-score/discuss/767922/Java-19-lines-greedy-with-line-by-line-explanation-easy-to-understand
 */
package com.an7one.leetcode.lvl4.lc1537;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach1DFSMemo {
    public int maxSum(int[] nums1, int[] nums2) {
        final int MOD = (int)1e9 + 7;
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        buildGraph(nums1, graph);
        buildGraph(nums2, graph);
        
        Map<Integer, Long> memo = new HashMap<Integer, Long>();
        return (int)Math.max(dfs(nums1[0], graph, memo) % MOD, 
                             dfs(nums2[0], graph, memo) % MOD);
    }
    
    private long dfs(int cur, 
                     Map<Integer, List<Integer>> graph, 
                     Map<Integer, Long> memo){
        if(memo.containsKey(cur)) return memo.get(cur);
        if(!graph.containsKey(cur)) return cur;
        
        long maxSum = 0;
        for(int next : graph.get(cur))
            maxSum = Math.max(maxSum, dfs(next, graph, memo));
        
        maxSum += cur;
        memo.put(cur, maxSum);
        return maxSum;
    }
    
    private void buildGraph(int[] nums, Map<Integer, List<Integer>> graph){
        final int N = nums.length;
        for(int i = 0; i < N - 1; ++i){
            graph.putIfAbsent(nums[i], new ArrayList<Integer>());
            graph.get(nums[i]).add(nums[i + 1]);
        }
    }
}