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
public class SolutionApproach0TwoPointers1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int greed = 0, candy = 0;

        while (greed < g.length && candy < s.length) {
            if (g[greed] > s[candy]) {
                ++candy;
            } else {
                ++greed;
                ++candy;
            }
        }

        return greed;
    }
}