/**
 * https://leetcode.com/problems/permutations/
 * 
 * Time Complexity:     O(N!)
 * Space Complexity:    O()
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
package com.zea7ot.lc.lvl3.lc0046;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        // a `LinkedHashSet` is required, instead of a `HashSet`,
        // to maintain the insertion order,
        // otherwise all orders of elements in subsets are the same.
        backtrack(new LinkedHashSet<Integer>(), nums, ans);
        return ans;
    }
    
    private void backtrack(Set<Integer> intermediate, 
                           int[] nums, 
                           List<List<Integer>> ans){
        final int N = nums.length;
        if(intermediate.size() == N){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(intermediate.contains(nums[i])) continue;
            intermediate.add(nums[i]);
            backtrack(intermediate, nums, ans);
            intermediate.remove(nums[i]);
        }
    }
}