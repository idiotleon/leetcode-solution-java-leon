package com.idiotleon.leetcode.lvl5.lc0140;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 * <p>
 * Time Complexity:     O()
 * Space Complexity:    O()
 * <p>
 * References:
 * https://leetcode.com/problems/word-break-ii/discuss/44179/Slightly-modified-DP-Java-solution
 */
@SuppressWarnings({Constant.WARNING.UNUSED})
public class SolutionApproach0DFSMemo {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        final Set<String> WORD_SET = new HashSet<>(wordDict);
        Map<String, List<String>> cache = new HashMap<>();

        return dfs(s, WORD_SET, cache);
    }

    private List<String> dfs(String str, final Set<String> wordSet, final Map<String, List<String>> memo) {
        if (memo.containsKey(str))
            return memo.get(str);
        final int L = str.length();

        List<String> res = new ArrayList<>();
        if (wordSet.contains(str))
            res.add(str);

        for (int i = 1; i < L; ++i) {
            String left = str.substring(0, i), right = str.substring(i);
            // if (WORD_SET.contains(left) && containsSuffix(right, WORD_SET))
            if (wordSet.contains(left))
                for (String sub : dfs(right, wordSet, memo))
                    res.add(left + " " + sub);
        }

        memo.put(str, res);
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