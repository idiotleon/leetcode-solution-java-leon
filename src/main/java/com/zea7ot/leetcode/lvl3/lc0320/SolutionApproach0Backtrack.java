/**
 * https://leetcode.com/problems/generalized-abbreviation/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/generalized-abbreviation/discuss/77218/Java-14ms-beats-100/427336
 */
package com.zea7ot.leetcode.lvl3.lc0320;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
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
            /**
             * since type StringBuilder is passed by reference,
             * proper backtrack should be taken to resume to the previous state.
             * 
             * what's more, the "digit" can be larger than 9, such as 10, which consists of 2 digits
             * 
             * to create a new StringBuilder based on "abbr", 
             * <code> new StringBuilder(abbr) </code> 
             * also works, with much more time&space cost.
             */
            if(digit != 0) abbr.append(digit);
            res.add(abbr.toString());
            // if(digit != 0) abbr.setLength(abbr.length() - ((digit > 9) ? 2 : 1));
            if(digit != 0) abbr.setLength(LEN);
            return;
        }
        
        
        // to abbreviate with chs[idx]
        backtrack(chs, abbr, idx + 1, digit + 1, res);
        
        // to keep the current character chs[idx]
        if(digit != 0) abbr.append(digit);
        backtrack(chs, abbr.append(chs[idx]), idx + 1, 0, res);
        
        abbr.setLength(LEN);
    }
}