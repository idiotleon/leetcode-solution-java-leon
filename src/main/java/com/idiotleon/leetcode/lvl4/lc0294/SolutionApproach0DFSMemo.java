/**
 * https://leetcode.com/problems/flip-game-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution/77005
 *  https://leetcode.com/problems/flip-game-ii/discuss/73954/Theory-matters-from-Backtracking(128ms)-to-DP-(0ms)
 */
package com.idiotleon.leetcode.lvl4.lc0294;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo{
    public boolean canWin(String s) {
        // sanity check
        if(s == null || s.length() < 2) return false;
        
        Map<String, Boolean> memo = new HashMap<String, Boolean>();
        return canWin(s, memo);
    }
    
    private boolean canWin(String str, Map<String, Boolean> memo){
        if(memo.containsKey(str)) return memo.get(str);
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == '+' && str.charAt(i + 1) == '+'){
                String opponent = str.substring(0, i) + "--" + str.substring(i + 2);
                if(!canWin(opponent, memo)){
                    memo.put(str, true);
                    return true;
                }
            }
        }
        memo.put(str, false);
        return false;
    }
}