package com.an7one.leetcode.lvl1.lc0455;

import com.an7one.util.Constant;

import java.util.Arrays;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/assign-cookies/">LC0455</a>
 * <p>
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0TwoPointers0 {
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int candy = 0, greed = 0;

        while (greed < g.length && candy < s.length) {
            // only greed can be satisfied, greed can move forward
            if (s[candy] >= g[greed]) {
                ++greed;
            }

            // no matter whether greed can be satisfied,
            // candy should move forward
            ++candy;
        }

        return greed;
    }
}