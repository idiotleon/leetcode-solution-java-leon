/**
 * https://leetcode.com/problems/find-the-difference/
 * 
 * Time Complexity:     O(LEN_S + LEN_T) ~ O(LEN_T)
 * Space Complexity:    O(1) / O(LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-difference/discuss/86825/Java-solution-using-bit-manipulation
 */
package com.idiotleon.leetcode.lvl1.lc0389;

public class SolutionApproach0BitXOR1 {
    public char findTheDifference(String s, String t) {
        
        final int LEN_T = t.length();
        char ch = t.charAt(LEN_T - 1);
        
        for(int i = 0; i < LEN_T - 1; ++i){
            ch ^= s.charAt(i);
            ch ^= t.charAt(i);
        }
        
        return ch;
    }
}
