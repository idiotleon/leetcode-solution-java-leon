/**
 * https://leetcode.com/problems/stepping-numbers/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/stepping-numbers/discuss/397601/Java-DFS-solution-(Read-this-if-you-got-TLE)
 */
package com.idiotleon.leetcode.lvl3.lc1215;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0DFSRecursive {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (long i = 0; i < 10; ++i) {
            dfs(i, low, high, ans);
        }
        Collections.sort(ans);

        return ans;
    }

    private void dfs(long cur, int lo, int hi, List<Integer> res) {
        if (cur >= lo && cur <= hi)
            res.add((int) cur);
        if (cur == 0 || cur > hi)
            return;

        long last = cur % 10;
        long inc = cur * 10 + last + 1;
        long dec = cur * 10 + last - 1;

        if (last == 0)
            dfs(inc, lo, hi, res);
        else if (last == 9)
            dfs(dec, lo, hi, res);
        else {
            dfs(inc, lo, hi, res);
            dfs(dec, lo, hi, res);
        }
    }
}
