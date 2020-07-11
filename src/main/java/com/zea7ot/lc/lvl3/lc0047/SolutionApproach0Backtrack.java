/**
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Time Complexity:     O(N!)
 * Space Complexity:    O()
 * 
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
package com.zea7ot.lc.lvl3.lc0047;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        boolean[] used = new boolean[N];
        // for duplicates
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), used, nums, ans);
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           boolean[] used, 
                           int[] nums, 
                           List<List<Integer>> ans){
        final int N = nums.length;
        if(intermediate.size() == N){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) continue;
            used[i] = true;
            intermediate.add(nums[i]);
            backtrack(intermediate, used, nums, ans);
            used[i] = false;
            intermediate.remove(intermediate.size() - 1);
        }
    }
}