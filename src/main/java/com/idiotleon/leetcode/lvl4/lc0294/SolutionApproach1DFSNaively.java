/**
 * https://leetcode.com/problems/flip-game-ii/
 * 
 * Time Complexity:     O(N!!)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flip-game-ii/discuss/73962/Share-my-Java-backtracking-solution
 *  https://leetcode.com/problems/flip-game-ii/discuss/73954/Theory-matters-from-Backtracking(128ms)-to-DP-(0ms)
 */
package com.idiotleon.leetcode.lvl4.lc0294;

public class SolutionApproach1DFSNaively {
    public boolean canWin(String s) {
        // sanity check
        if(s == null || s.length() < 2) return false;
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.startsWith("++", i)){
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                
                if(!canWin(t)) return true;
            }
        }
        
        return false;
    }
}