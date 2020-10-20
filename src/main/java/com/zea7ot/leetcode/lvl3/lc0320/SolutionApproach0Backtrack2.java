/**
 * https://leetcode.com/problems/generalized-abbreviation/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/generalized-abbreviation/discuss/77190/Java-backtracking-solution
 */
package com.zea7ot.leetcode.lvl3.lc0320;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack2 {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (word == null)
            return ans;

        backtrack(word, "", 0, 0, ans);
        return ans;
    }

    private void backtrack(String word, String abbr, int idx, int digit, List<String> res) {
        if (idx == word.length()) {
            if (digit > 0)
                abbr += digit;
            res.add(abbr);
            return;
        }

        backtrack(word, abbr, idx + 1, digit + 1, res);
        backtrack(word, abbr + (digit > 0 ? digit : "") + word.charAt(idx), idx + 1, 0, res);
    }
}