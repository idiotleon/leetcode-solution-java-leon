/**
 * https://leetcode.com/problems/frog-jump/
 * 
 * TLEd
 */
package com.zea7ot.lc.lvl5.lc0403;

public class SolutionApproach0DFS1 {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        
        return canCross(stones, 0, 0);
    }
    
    private boolean canCross(int[] stones, int pos, int k){
        for(int i = pos + 1; i < stones.length; i++){
            int gap = stones[i] - stones[pos];
            if(gap < k - 1) continue;
            if(gap > k + 1) return false;
            if(canCross(stones, i, gap)) return true;
        }
        
        return pos == stones.length - 1;
    }
}