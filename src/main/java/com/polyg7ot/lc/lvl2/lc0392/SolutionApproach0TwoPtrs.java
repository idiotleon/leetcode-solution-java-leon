/**
 * https://leetcode.com/problems/is-subsequence/
 * 
 * Time Complexity: O(LEN_T)
 * Space Complexity: O(LEN_S + LEN_T) or O(1)
 * 
 * References:
 *  https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-matching-subsequences/
 */
package com.polyg7ot.lc.lvl2.lc0392;

public class SolutionApproach0TwoPtrs {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length()) return false;
        
        if(s.length() == 0) return true;
        
        char[] chsS = s.toCharArray(), chsT = t.toCharArray();
        
        int idxS = 0, idxT = 0;
        while(idxT < t.length()){
            if(chsS[idxS] == chsT[idxT]){
                idxS++;
                if(idxS == s.length()) return true;
            }
            
            idxT++;
        }
        
        return false;
    }
}