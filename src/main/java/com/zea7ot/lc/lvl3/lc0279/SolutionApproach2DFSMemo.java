/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)/233322
 */
package com.zea7ot.lc.lvl3.lc0279;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach2DFSMemo {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = n; i > 0; i--){
            if(i * i <= n) {
                list.add(i * i);
            }
        }
        
        return dfs(list, n, new HashMap<Integer, Integer>());
    }
    
    private int dfs(List<Integer> list, 
                    int num, 
                    Map<Integer, Integer> memo){
        if(num == 0) return 0;
        
        if(memo.containsKey(num)) return memo.get(num);
        
        int min = Integer.MAX_VALUE;
        for(int i : list){
            if(i > num) continue;
            
            int level = dfs(list, num - i, memo);
            if(level < min) min = level;
        }
        
        min = min == Integer.MAX_VALUE ? min : min + 1;
        memo.put(num, min);
        return min;
    }
}