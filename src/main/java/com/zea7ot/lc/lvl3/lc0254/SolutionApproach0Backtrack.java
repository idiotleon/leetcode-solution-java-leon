/**
 * https://leetcode.com/problems/factor-combinations/
 * 
 * Time Complexity:     ?O(n * lg(n))
 * Space Complexity:    ?O(n * lg(n))
 * 
 * References:
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/165582
 *  https://leetcode.com/problems/factor-combinations/discuss/68040/My-Recursive-DFS-Java-Solution/159196
 */
package com.zea7ot.lc.lvl3.lc0254;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
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
                // to collect results during the recursion
                path.add(target / i);
                paths.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                backtrack(path, target / i, i, paths);
                path.remove(path.size() - 1);
            }
        }
    }
}