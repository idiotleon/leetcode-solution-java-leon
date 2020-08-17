/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
 */
package com.zea7ot.leetcode.lvl2.lc1047;

public class SolutionApproach0TwoPointers1 {
    public String removeDuplicates(String S) {
        final int L = S.length();
        char[] chs = S.toCharArray();
        
        int i = 0, j = 0;
        while(j < L){
            chs[i] = chs[j];
            
            if(i > 0 && chs[i - 1] == chs[i])
                i -= 2;
            
            ++i;
            ++j;
        }
        
        return new String(chs, 0, i);
    }
}