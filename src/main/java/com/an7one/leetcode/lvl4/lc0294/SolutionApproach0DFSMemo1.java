/**
 * https://leetcode.com/problems/flip-game-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution/77009
 *  https://leetcode.com/problems/flip-game-ii/discuss/73954/Theory-matters-from-Backtracking(128ms)-to-DP-(0ms)
 */
package com.an7one.leetcode.lvl4.lc0294;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFSMemo1 {
    public  boolean canWin(String s) {
        // sanity check
        if(s == null || s.length() < 2) return false;
        
        Set<String> winSet = new HashSet<String>();
        return canWin(s, winSet);
    }
    
    private boolean canWin(String str, Set<String> winSet){
        if(winSet.contains(str)) return true;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == '+' && str.charAt(i + 1) == '+'){
                String opponent = str.substring(0, i) + "--" + str.substring(i + 2);
                if(!canWin(opponent, winSet)){
                    winSet.add(str);
                    return true;
                }
            }
        }
        return false;
    }
}