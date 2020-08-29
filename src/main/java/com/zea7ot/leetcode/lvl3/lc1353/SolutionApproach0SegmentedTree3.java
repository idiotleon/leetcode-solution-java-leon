/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(RANGE)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/718239/Thinking-Process%3A-Greedy-Segment-Tree
 */
package com.zea7ot.leetcode.lvl3.lc1353;

import java.util.Arrays;

public class SolutionApproach0SegmentedTree3 {
    private int[] ALL_DAYS;

    public int maxEvents(int[][] events) {
        final int RANGE = (int) 1e5 + 1;
        ALL_DAYS = new int[4 * RANGE];
        build(1, 1, RANGE);

        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        for (int[] event : events) {
            int start = event[0], end = event[1];
            int firstAvailable = rangeQuery(1, start, end, 1, RANGE);
            if (firstAvailable != 0 && firstAvailable <= end) {
                ++count;
                update(1, firstAvailable, 1, RANGE);
            }
        }

        return count;
    }

    private int rangeQuery(int idx, int lo, int hi, final int LEFT, final int RIGHT) {
        if (lo >= LEFT && hi <= RIGHT)
            return ALL_DAYS[idx];

        int mid = lo + (hi - lo) / 2;
        int res = Integer.MAX_VALUE;

        if (mid >= LEFT && lo <= RIGHT)
            res = Math.min(res, rangeQuery(2 * idx, lo, mid, LEFT, RIGHT));

        if (mid + 1 <= RIGHT && hi >= LEFT)
            res = Math.min(res, rangeQuery(2 * idx + 1, mid + 1, hi, LEFT, RIGHT));

        return res;
    }

    private int update(int idx, int pos, int lo, int hi) {
        if (lo == hi) {
            ALL_DAYS[idx] = Integer.MAX_VALUE;
        } else {
            int mid = lo + (hi - lo) / 2;

            if (pos <= mid)
                ALL_DAYS[idx] = Math.min(ALL_DAYS[2 * idx + 1], update(2 * idx, pos, lo, mid));
            else
                ALL_DAYS[idx] = Math.min(ALL_DAYS[2 * idx], update(2 * idx + 1, pos, mid + 1, hi));

        }

        return ALL_DAYS[idx];
    }

    private int build(int idx, int lo, int hi) {
        if (lo == hi)
            ALL_DAYS[idx] = lo;
        else {
            int mid = lo + (hi - lo) / 2;
            ALL_DAYS[idx] = Math.min(build(2 * idx, lo, mid), build(2 * idx + 1, mid + 1, hi));
        }

        return ALL_DAYS[idx];
    }
}