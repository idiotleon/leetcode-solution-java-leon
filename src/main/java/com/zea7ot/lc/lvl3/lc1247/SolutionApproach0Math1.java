/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L) / O(1)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/discuss/419351/Java-Solution-with-detailed-comments
 */
package com.zea7ot.lc.lvl3.lc1247;

public class SolutionApproach0Math1 {
    public int minimumSwap(String s1, String s2) {
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        
        final int L = s1.length();
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        for(int i = 0; i < L; i++){
            char ch1 = chs1[i], ch2 = chs2[i];
            if(ch1 == ch2) continue;
            if(ch1 == 'x') x1++;
            else y1++;
            
            if(ch2 == 'x') x2++;
            else y2++;
        }
        
        if((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) return -1;
        
        return x1 / 2 + y1 / 2 + (x1 % 2) * 2;
    }
}