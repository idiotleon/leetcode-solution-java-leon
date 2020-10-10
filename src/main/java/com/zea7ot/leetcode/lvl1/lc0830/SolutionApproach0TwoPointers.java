/**
 * https://leetcode.com/problems/positions-of-large-groups/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/positions-of-large-groups/discuss/128957/C%2B%2BJavaPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl1.lc0830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        // sanity check
        if (s == null || s.isEmpty())
            return ans;

        final int L = s.length();
        final char[] CHS = s.toCharArray();

        int lo = 0, hi = 0;

        while (hi < L) {
            while (hi < L && CHS[lo] == CHS[hi]) {
                ++hi;
            }

            if (hi - lo >= 3) {
                ans.add(Arrays.asList(lo, hi - 1));
            }

            lo = hi;
            ++hi;
        }

        return ans;
    }
}
