/**
 * https://leetcode.com/problems/combination-sum/
 */

package main.java.lcidiot.lc0039;

import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return ans;
        
        dfs(ans, new ArrayList(), candidates, target, 0);
        
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] candidates, 
                     int target, 
                     int index){
        if(target < 0) return;
        
        if(target == 0){
            ans.add(new ArrayList(intermediate));
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            intermediate.add(candidates[i]);
            dfs(ans, intermediate, candidates, target - candidates[i], i);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}