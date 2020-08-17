/**
 * https://leetcode.com/problems/generalized-abbreviation/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/generalized-abbreviation/discuss/77218/Java-14ms-beats-100
 */
package com.zea7ot.leetcode.lvl3.lc0320;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(word == null) return ans;
        
        backtrack(word.toCharArray(), new StringBuilder(), 0, 0, ans);
        return ans;
    }
    
    private void backtrack(char[] chs, 
                           StringBuilder abbr, 
                           int idx, 
                           int digit, 
                           List<String> res){
        
        final int LEN = abbr.length();
        
        if(idx == chs.length){
            if(digit != 0) abbr.append(digit);
            res.add(abbr.toString());
        }else{
            // to abbreviate with chs[i]
            backtrack(chs, abbr, idx + 1, digit + 1, res);
            
            // not to abbreviate with chs[i]
            // to keep the current character chs[i]
            if(digit != 0) abbr.append(digit);
            backtrack(chs, abbr.append(chs[idx]), idx + 1, 0, res);
        }
        
        abbr.setLength(LEN);
    }
}