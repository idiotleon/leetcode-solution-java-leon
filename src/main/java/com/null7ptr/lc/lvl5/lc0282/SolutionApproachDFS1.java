/**
 * https://leetcode.com/problems/expression-add-operators/
 */
package com.null7ptr.lc.lvl5.lc0282;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDFS1 {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        dfs(ans, builder, num, 0, target, 0, 0);
        return ans;
    }
    
    private void dfs(List<String> paths, 
                     StringBuilder builder, 
                     String num, 
                     int pos, 
                     int target, 
                     long prev, 
                     long multi){
        
        if(pos == num.length()){
            if(target == prev){
                paths.add(builder.toString());
                return;
            }
        }
        
        for(int i = pos; i < num.length(); i++){
            if(num.charAt(pos) == '0' && i != pos) break;
            
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = builder.length();
            if(pos == 0){
                dfs(paths, builder.append(cur), num, i + 1, target, cur, cur);
                builder.setLength(len);
            }else{
                dfs(paths, builder.append("+").append(cur), num, i + 1, target, prev + cur, cur);
                builder.setLength(len);
                
                dfs(paths, builder.append("-").append(cur), num, i + 1, target, prev - cur, -cur);
                builder.setLength(len);
                
                dfs(paths, builder.append("*").append(cur), num, i + 1, target, prev - multi + multi * cur, multi * cur);
                builder.setLength(len);
            }
        }
    }
}