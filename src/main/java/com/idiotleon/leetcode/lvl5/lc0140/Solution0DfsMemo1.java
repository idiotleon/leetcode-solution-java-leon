package com.idiotleon.leetcode.lvl5.lc0140;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * https://leetcode.com/problems/word-break-ii/
 * <p>
 * Time complexity :    O(N ^ 3) + O(N)
 * Size of recursion tree can go up to (N ^ 2).
 * The creation of list takes (N ^ 2) time.
 * <p>
 * Space complexity :   O(N ^ 3)
 * The depth of the recursion tree can go up to (N ^ 2),
 * and each activation record can contain a string list of size (N ^ 2).
 * <p>
 * <p>
 * References:
 * https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
 * https://leetcode.com/problems/word-break-ii/discuss/44353/My-DP-solution-in-JAVA
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0DfsMemo1 {
    public List<String> wordBreak(String str, List<String> wordDict) {
        final Map<Integer, List<String>> memo = new HashMap<>();
        final Set<String> WORD_SET = new HashSet<>(wordDict);
        return dfs(0, str, WORD_SET, memo);
    }

    private List<String> dfs(int start, String str, final Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        final List<String> res = new ArrayList<>();
        final int L = str.length();
        if (start == L) {
            res.add("");
        }

        for (int end = start + 1; end <= L; ++end) {
            String sub = str.substring(start, end);
            if (!wordSet.contains(sub)) {
                continue;
            }
            List<String> lists = dfs(end, str, wordSet, memo);
            for (String list : lists) {
                res.add(sub + (list.equals("") ? "" : " ") + list);
            }
        }

        memo.put(start, res);
        return res;
    }
}