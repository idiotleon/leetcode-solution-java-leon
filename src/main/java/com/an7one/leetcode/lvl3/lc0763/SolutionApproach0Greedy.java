package com.an7one.leetcode.lvl3.lc0763;

import com.an7one.util.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leon
 * https://leetcode.com/problems/partition-labels/
 *
 * Time Complexity:     2 * O(L) ~ O(L)
 * Space Complexity:    O(L), consumed by the answer array/list
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0Greedy {
    public List<Integer> partitionLabels(String str) {
        final List<Integer> ans = new ArrayList<>();
        // sanity check
        if (str == null || str.isEmpty())
            return ans;

        final char[] chs = str.toCharArray();
        final int L = str.length();

        final int[] lastIndices = new int[26];
        // to record the last index of each char
        for (int i = 0; i < L; i++) {
            lastIndices[chs[i] - 'a'] = i;
        }

        // to record the end index of the current substring
        int lo = 0, hi = 0;
        int last = 0;
        while (hi < L) {
            last = Math.max(last, lastIndices[chs[hi] - 'a']);
            if (last == hi) {
                ans.add(hi - lo + 1);
                lo = hi + 1;
            }

            ++hi;
        }

        return ans;
    }
}