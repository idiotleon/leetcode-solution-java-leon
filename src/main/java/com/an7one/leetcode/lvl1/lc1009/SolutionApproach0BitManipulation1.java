/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * 
 * Time Complexity:     O(lg(`N`))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/258500/Java-0ms-32mb...-beats-100
 *  https://leetcode.com/problems/complement-of-base-10-integer/discuss/613118/4-approaches%3A-bitwise-operation-math-formular-one-naive-simulation-and-bonus
 */
package com.an7one.leetcode.lvl1.lc1009;

public class SolutionApproach0BitManipulation1 {
    public int bitwiseComplement(int N) {
        if(N == 0) return 1;
        if(N == 1) return 0;
        
        int x = 1;
        while(x <= N){
            x = x << 1;
        }
        
        return N ^ (x - 1);
    }
}
