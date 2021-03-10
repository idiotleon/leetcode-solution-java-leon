/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/discuss/425557/Java-concise-solution-w-explanation
 */
package com.an7one.leetcode.lvl3.lc1247;

public class SolutionApproach0Math {
    public int minimumSwap(String s1, String s2) {
        final int L = s1.length();
        
        int x = 0, y = 0;
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        
        for(int i = 0; i < L; i++){
            if(chs1[i] != chs2[i]){
                if(chs1[i] == 'x') x++;
                else y++;
            }
        }
        
        int count = x + y;
        
        if(count % 2 != 0) return -1;
        
        return count / 2 + x % 2;
    }
}