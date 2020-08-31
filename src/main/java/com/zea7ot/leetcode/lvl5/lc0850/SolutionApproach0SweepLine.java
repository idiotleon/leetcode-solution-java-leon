/**
 * https://leetcode.com/problems/rectangle-area-ii/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/rectangle-area-ii/discuss/188832/Java-Line-Sweep-With-Sub-Class-Interval
 */
package com.zea7ot.leetcode.lvl5.lc0850;

import java.util.Arrays;
import java.util.TreeMap;

public class SolutionApproach0SweepLine {
    private static final int MOD = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        // sanity check
        if (rectangles == null || rectangles.length == 0)
            return 0;

        final int N = rectangles.length;
        final int OPEN = 0, CLOSED = 1;
        final int[][] EVENTS = new int[N * 2][4];

        int idx = 0;
        for (int[] rectangle : rectangles) {
            EVENTS[idx++] = new int[] { rectangle[1], OPEN, rectangle[0], rectangle[2] };
            EVENTS[idx++] = new int[] { rectangle[3], CLOSED, rectangle[0], rectangle[2] };
        }

        Arrays.sort(EVENTS, (a, b) -> Integer.compare(a[0], b[0]));

        final TreeMap<Interval, Integer> AXIS_X = new TreeMap<>((a, b) -> {
            if (a.start != b.start)
                return Integer.compare(a.start, b.start);
            return Integer.compare(a.end, b.end);
        });

        int prevY = EVENTS[0][0];
        long ans = 0;
        for (final int[] EVENT : EVENTS) {
            int curY = EVENT[0], type = EVENT[1], x1 = EVENT[2], x2 = EVENT[3];

            if (curY > prevY) {
                ans += sweepLine(AXIS_X) * (curY - prevY);
                prevY = curY;
            }

            if (type == OPEN) {
                addInterval(x1, x2, AXIS_X);
            } else {
                removeInterval(x1, x2, AXIS_X);
            }
        }

        ans %= MOD;
        return (int) ans;
    }

    private long sweepLine(TreeMap<Interval, Integer> AXIS_X) {
        long query = 0;
        int cur = -1;
        for (Interval interval : AXIS_X.keySet()) {
            cur = Math.max(cur, interval.start);
            query += Math.max(interval.end - cur, 0);
            cur = Math.max(cur, interval.end);
        }

        return query;
    }

    private void removeInterval(int x1, int x2, TreeMap<Interval, Integer> AXIS_X) {
        Interval interval = new Interval(x1, x2);
        AXIS_X.put(interval, AXIS_X.getOrDefault(interval, 0) - 1);
        if (AXIS_X.get(interval) == 0)
            AXIS_X.remove(interval);
    }

    private void addInterval(int x1, int x2, TreeMap<Interval, Integer> AXIS_X) {
        Interval interval = new Interval(x1, x2);
        AXIS_X.put(interval, AXIS_X.getOrDefault(interval, 0) + 1);
    }

    private class Interval {
        private int start;
        private int end;

        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}