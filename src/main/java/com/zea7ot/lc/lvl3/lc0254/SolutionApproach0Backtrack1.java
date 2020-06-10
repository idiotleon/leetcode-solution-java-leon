/**
 * @author: Leon
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Time Complexity:     ?O(n ^ 2)
 * Space Complexity:    O(lg(n))
 */
package com.zea7ot.lc.lvl3.lc0254;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(n <= 3) return ans;
        
        backtrack(new ArrayList<Integer>(), n, 2, ans);
        return ans;
    }
    
    private void backtrack(List<Integer> path, 
                           int target, 
                           int start, 
                           List<List<Integer>> paths){
        if(target == 1 && path.size() > 1){
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = start; i * i <= target; i++){
            if(target % i == 0){
                path.add(i);
                backtrack(path, target / i, i, paths);
                path.remove(path.size() - 1);
            }
        }
    }
}