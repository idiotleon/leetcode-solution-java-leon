/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * Time Complexity:     2 * O(L) ~ O(L)
 * Space Complexity:    O(L), consumed by the answer array/list
 */
package com.an7one.leetcode.lvl3.lc0763;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Greedy {
    public List<Integer> partitionLabels(String str) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (str == null || str.isEmpty())
            return ans;

        final char[] CHS = str.toCharArray();
        final int L = str.length();

        int[] lastIdxes = new int[26];
        // to record the last index of each char
        for (int i = 0; i < L; i++)
            lastIdxes[CHS[i] - 'a'] = i;

        // to record the end index of the current substring
        int lo = 0, hi = 0;
        int last = 0;
        while (hi < L) {
            last = Math.max(last, lastIdxes[CHS[hi] - 'a']);
            if (last == hi) {
                ans.add(hi - lo + 1);
                lo = hi + 1;
            }

            ++hi;
        }

        return ans;
    }
}