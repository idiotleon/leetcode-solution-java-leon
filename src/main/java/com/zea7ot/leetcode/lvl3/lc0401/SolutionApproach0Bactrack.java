/**
 * https://leetcode.com/problems/binary-watch/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/binary-watch/discuss/88456/3ms-Java-Solution-Using-Backtracking-and-Idea-of-"Permutation-and-Combination"/118980
 */
package com.zea7ot.leetcode.lvl3.lc0401;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Bactrack {
    private static final int[] CANDIDATES = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        backtrack(0, 0, 0, num, ans);
        return ans;
    }
    
    private void backtrack(int hour, int min, int idx, int num, List<String> res){
        if(hour > 12 || min > 59 || hour == 12 && min == 0 || num < 0 || idx > CANDIDATES.length) return;
        
        if(num == 0){
            res.add(hour + ":" + (min < 10 ? "0" + min : min));
            return;
        }
        
        if(num <= 10 - idx){
            // ??
            backtrack(hour, min, idx + 1, num, res);
            
            if(idx < 4){
                backtrack(hour + CANDIDATES[idx], min, idx + 1, num - 1, res);
            }else{
                backtrack(hour, min + CANDIDATES[idx], idx + 1, num - 1, res);
            }
        }
    }
}