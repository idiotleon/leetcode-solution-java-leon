/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0459;

public class SolutionApproachKMP {
    public boolean repeatedSubstringPattern(String s) {
        // sanity check
        if(s == null || s.isEmpty()) return true;
        
        final int L = s.length();
        int[] kmpTable = new int[L];
        int i = 1, j = 0;
        while(i < L){
            if(s.charAt(j) == s.charAt(i)){
                kmpTable[i++] = ++j;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        return kmpTable[L - 1] != 0 && L % (L - kmpTable[L - 1]) == 0;
    }
}