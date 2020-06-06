/**
 * https://leetcode.com/problems/expression-add-operators/
 * 
 * Time Complexity: O(3 ^ N)
 * Space Complexity: O(N)
 * https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
 */
package com.zea7ot.lc.lvl5.lc0282;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS2 {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        if(num == null || num.isEmpty()) return ans;
        
        dfs(ans, "", num, target, 0, 0, 0);
        
        return ans;
    }
    
    private void dfs(List<String> paths, 
                     String path, 
                     String num, 
                     int target, 
                     int pos, 
                     long res, 
                     long prev){
        if(pos == num.length()){
            if(target == res) {
                paths.add(path);
                return;
            }
        }
        
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                dfs(paths, path + cur, num, target, i + 1, cur, cur);
            }else{
                dfs(paths, path + '+' + cur, num, target, i + 1, res + cur, cur);
                
                dfs(paths, path + "-" + cur, num, target, i + 1, res - cur, -cur);
                
                dfs(paths, path + "*" + cur, num, target, i + 1, res - prev + prev * cur, prev * cur);
            }
        }
    }
}