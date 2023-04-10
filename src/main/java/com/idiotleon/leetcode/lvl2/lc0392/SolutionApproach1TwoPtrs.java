/**
 * https://leetcode.com/problems/is-subsequence/
 * 
 * Time Complexity: O(LEN_T)
 * Space Complexity: O(LEN_S + LEN_T) or O(1)
 * 
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-matching-subsequences/
 */
package com.idiotleon.leetcode.lvl2.lc0392;

public class SolutionApproach1TwoPtrs {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length()) return false;
        
        if(s.length() == 0) return true;
        
        char[] chsS = s.toCharArray(), chsT = t.toCharArray();
        
        int idxS = 0, idxT = 0;
        while(idxT < t.length()){
            while(idxT < chsT.length && chsS[idxS] != chsT[idxT]){
                idxT++;
            }
            
            while(idxT < chsT.length && chsS[idxS] == chsT[idxT]){
                idxS++;
                idxT++;
                if(idxS == s.length()) return true;
            }
        }
        
        return idxS == s.length();
    }
}