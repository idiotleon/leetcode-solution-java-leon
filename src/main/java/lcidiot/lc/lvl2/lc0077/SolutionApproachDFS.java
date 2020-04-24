/**
 * https://leetcode.com/problems/combinations/
 */
package main.java.lcidiot.lc.lvl2.lc0077;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(ans, new ArrayList<Integer>(), 1, n, k);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int start, 
                     int n,
                     int k){
        if(k == 0){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = start; i <= n; i++){
            intermediate.add(i);
            dfs(ans, intermediate, i + 1, n, k-1);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}