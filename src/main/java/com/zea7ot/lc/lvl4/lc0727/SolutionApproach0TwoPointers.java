/**
 * https://leetcode.com/problems/minimum-window-subsequence/
 * 
 * Time Complexity:     O(LEN_S ^ 2)
 * Space Complexity:    O(LEN_S + LEN_T)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-window-subsequence/discuss/109356/JAVA-two-pointer-solution-(12ms-beat-100)-with-explaination/211042
 */
package com.zea7ot.lc.lvl4.lc0727;

public class SolutionApproach0TwoPointers {
    public String minWindow(String S, String T) {
        String ans = "";
        // sanity check
        if(S.isEmpty() || T.isEmpty()) return ans;
        
        final int LEN_S = S.length(), LEN_T = T.length();
        int idxS = 0, idxT = 0;
        int len = Integer.MAX_VALUE;
        
        char[] chsS = S.toCharArray(), chsT = T.toCharArray();
        
        while(idxS < LEN_S){
            if(chsS[idxS] == chsT[idxT]){ 
                ++idxT;
                if(idxT == LEN_T){ // all chars in `chsT` have been matched
                    // to check feasibility from left to right of T
                    int end = idxS + 1; // `idxS` is the last match index in `chsS`/`S`
                    // to check optimization from right to left of T
                    --idxT; // now 'idxT' is the last index in `chsT`/`T`
                    while(idxT >= 0) {
                        if(chsS[idxS] == chsT[idxT]){
                            --idxT;
                        }
                        --idxS;
                    }

                    ++idxS; // first matching index in `chsS` has been found
                    ++idxT; // 

                    // to record the current smallest candidate
                    if(end - idxS < len){
                        len = end - idxS;
                        ans = S.substring(idxS, end); // [idxS, end) is the matching subsequence
                    }
                }
            }
            
            ++idxS;
        }
        
        return len == Integer.MAX_VALUE ? "" : ans;
    }
}