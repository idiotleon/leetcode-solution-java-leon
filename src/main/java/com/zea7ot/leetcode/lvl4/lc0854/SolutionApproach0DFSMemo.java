/**
 * https://leetcode.com/problems/k-similar-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/k-similar-strings/discuss/139872/Java-Backtracking-with-Memorization
 *  https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC++-O(N)-solution-using-cyclic-swapping
 */
package com.zea7ot.leetcode.lvl4.lc0854;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo {
    public int kSimilarity(String A, String B) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, A.toCharArray(), B, memo);
    }

    private int dfs(int idx, final char[] CHS_S, String B, Map<String, Integer> memo) {
        final int LEN_S = CHS_S.length;
        final int LEN_B = B.length();
        String str = new String(CHS_S);
        if (str.equals(B))
            return 0;

        if (memo.containsKey(str))
            return memo.get(str);

        int min = Integer.MAX_VALUE;
        int lo = idx;
        while (lo < LEN_S && CHS_S[lo] == B.charAt(lo)) {
            ++lo;
        }

        for (int hi = lo + 1; hi < LEN_B; ++hi) {
            if (CHS_S[hi] != B.charAt(lo))
                continue;
            swap(lo, hi, CHS_S);
            int next = dfs(idx + 1, CHS_S, B, memo);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, next + 1);
            }
            swap(lo, hi, CHS_S);
        }

        memo.put(str, min);
        return min;
    }

    private void swap(int lo, int hi, final char[] CHS) {
        char temp = CHS[lo];
        CHS[lo] = CHS[hi];
        CHS[hi] = temp;
    }
}
