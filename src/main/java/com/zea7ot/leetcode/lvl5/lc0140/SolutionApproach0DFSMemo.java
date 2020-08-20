/**
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/word-break-ii/discuss/44179/Slightly-modified-DP-Java-solution
 */
package com.zea7ot.leetcode.lvl5.lc0140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFSMemo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        final Set<String> WORD_SET = new HashSet<String>(wordDict);
        Map<String, List<String>> cache = new HashMap<>();

        return dfs(s, WORD_SET, cache);
    }

    private List<String> dfs(String str, final Set<String> WORD_SET, final Map<String, List<String>> CACHE) {
        if (CACHE.containsKey(str))
            return CACHE.get(str);
        final int L = str.length();

        List<String> res = new ArrayList<String>();
        if (WORD_SET.contains(str))
            res.add(str);

        for (int i = 1; i < L; ++i) {
            String left = str.substring(0, i), right = str.substring(i);
            // if (WORD_SET.contains(left) && containsSuffix(right, WORD_SET))
            if (WORD_SET.contains(left))
                for (String sub : dfs(right, WORD_SET, CACHE))
                    res.add(left + " " + sub);
        }

        CACHE.put(str, res);
        return res;
    }

    // private boolean containsSuffix(String str, final Set<String> WORD_SET) {
    // final int L = str.length();
    // for (int i = 0; i < L; ++i) {
    // if (WORD_SET.contains(str.substring(i)))
    // return true;
    // }

    // return false;
    // }
}