/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 * Time Complexity:     O(d * f * target)
 * Space Complexity:    O(d * target)
 * 
 * a top-down approach
 * 
 * References:
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355841/Java-Memo-DFS
 *  https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355940/C%2B%2B-Coin-Change-2
 */
package com.an7one.leetcode.lvl3.lc1155;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo2 {
    private static final int MOD = (int)(1e9 + 7);
    private Map<String, Integer> memo = new HashMap<String, Integer>();
    
    public int numRollsToTarget(int d, int f, int target) {
        if(d == 0 && target == 0) return 1;
        if(d > target || d * f < target) return 0;
        // not pruning enough, compared to the above
        // if(d == 0 || target == 0) return 0;
        
        String str = d + " " + target;
        if(memo.containsKey(str)) return memo.get(str);
        
        int count = 0;
        for(int i = 1; i <= f; i++){
            if(target >= i) 
                count = (count + numRollsToTarget(d - 1, f, target - i)) % MOD;
            else break;
        }
        memo.put(str, count);
        return count;
    }
}