/**
 * @author: Leon
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * Time Complexity:     O(9 ^ k)
 * Space Complexity:    O(k)
 */
package com.zea7ot.lc.lvl3.lc0216;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        final int FACTORIAL_NINE = 362880;
        if(k <= 0 || k > 9 || n <= 0 || n > FACTORIAL_NINE) return ans;
        
        backtrack(new ArrayList<Integer>(), 1, k, n, ans);
        
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int start, 
                           int k, 
                           int target, 
                           List<List<Integer>> ans){
        if(target < 0 || k < 0) return;
        
        if(k == 0){
            if(target == 0){
                ans.add(new ArrayList<Integer>(intermediate));
                return;
            }
        }
        
        for(int i = start; i < 10; i++){
            intermediate.add(i);
            backtrack(intermediate, i + 1, k - 1, target - i, ans);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}