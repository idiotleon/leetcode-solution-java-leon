/**
 * https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574943/Java-Detailed-Explanation-with-Graph-Demo-DP-Easy-Understand
 * 
 * Time Complexity:     O(n)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574943/Java-Detailed-Explanation-with-Graph-Demo-DP-Easy-Understand
 */
package com.zea7ot.lc.lvl4.lc1411;

public class SolutionApproach0DP {
    private static final int MOD = (int)1e9 + 7;
    
    public int numOfWays(int n) {
        long color3 = 6;
        long color2 = 6;
        
        for(int i = 2; i <= n; ++i){
            long tempColor3 = color3;
            color3 = (2 * color3 + 2 * color2) % MOD;
            color2 = (2 * tempColor3 + 3 * color2) % MOD;
        }
        
        return (int)(color3 + color2) % MOD;
    }
}