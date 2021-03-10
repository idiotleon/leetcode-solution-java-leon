/**
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Time complexity :    O(N ^ 3) + O(N)
 *  Size of recursion tree can go up to (N ^ 2). 
 *  The creation of list takes (N ^ 2) time.
 * 
 * Space complexity :   O(N ^ 3)
 *  The depth of the recursion tree can go up to (N ^ 2),
 *  and each activation record can contains a string list of size (N ^ 2).
 * 
 * 
 * References:
 *  https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS
 *  https://leetcode.com/problems/word-break-ii/discuss/44353/My-DP-solution-in-JAVA
 */
package com.an7one.leetcode.lvl5.lc0140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFSMemo1 {
    public List<String> wordBreak(String str, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<Integer, List<String>>();
        final Set<String> WORD_SET = new HashSet<String>(wordDict);
        return dfs(0, str, WORD_SET, memo);
    }

    private List<String> dfs(int start, String str, final Set<String> WORD_SET, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start))
            return memo.get(start);

        List<String> res = new ArrayList<String>();
        final int L = str.length();
        if (start == L)
            res.add("");

        for (int end = start + 1; end <= L; ++end) {
            String sub = str.substring(start, end);
            if (!WORD_SET.contains(sub))
                continue;
            List<String> lists = dfs(end, str, WORD_SET, memo);
            for (String list : lists) {
                res.add(sub + (list.equals("") ? "" : " ") + list);
            }
        }

        memo.put(start, res);
        return res;
    }
}