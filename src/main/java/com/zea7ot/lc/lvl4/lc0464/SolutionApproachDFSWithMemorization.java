/**
 * https://leetcode.com/problems/can-i-win/
 * 
 * Top Down DFS
 * 
 * #BitMap
 */
package com.zea7ot.lc.lvl4.lc0464;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproachDFSWithMemorization {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Map<Integer, Boolean> game = new HashMap<Integer, Boolean>();
        int signature = 0;
        
        // no one can be guaranteed to win
        if((1 + maxChoosableInteger) * maxChoosableInteger < desiredTotal * 2) return false;
        
        return canIWin(maxChoosableInteger, desiredTotal, signature, game);
    }
    
    private boolean canIWin(int maxChoosableInteger,
                            int desiredTotal, 
                            int signature, 
                            Map<Integer, Boolean> game){
        if(game.containsKey(signature)) return game.get(signature);
        
        for(int i = maxChoosableInteger; i > 0; i--){
            int bit = (1 << (i - 1));  
            if((signature & bit) == 0){ 
                desiredTotal = desiredTotal - i;
                if((desiredTotal <= 0) 
                   || !canIWin(maxChoosableInteger, desiredTotal, signature | bit, game)){
                    game.put(signature, true);
                    return true;
                }
                desiredTotal = desiredTotal + i;
            }
        }
        game.put(signature, false);
        return false;
    }
}