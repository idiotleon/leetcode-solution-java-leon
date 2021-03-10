/**
 * https://leetcode.com/problems/self-crossing/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/self-crossing/discuss/79168/Simple-Java-Solution
 */
package com.an7one.leetcode.lvl5.lc0335;

public class SolutionApproach0Math {
    public boolean isSelfCrossing(int[] x) {
        final int L = x.length;
        if(L <= 2) return false;
        
        int idx = 2;
        // to keep spiraling outward
        while(idx < L && x[idx] > x[idx - 2]) idx++;
        if(idx >= L) return false;
        
        // to transit from spiraling outward to spiralling inward
        if((idx >= 4 && x[idx] >= x[idx - 2] - x[idx - 4]) 
           || (idx == 3 && x[idx] == x[idx - 2])){
            x[idx - 1] -= x[idx - 3];
        }
        
        idx++;
        
        // to keep spiraling inward
        while(idx < L){
            if(x[idx] >= x[idx - 2]) return true;
            idx++;
        }
        
        return false;
    }
}