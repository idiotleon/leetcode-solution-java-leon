/**
 * https://leetcode.com/problems/maximum-number-of-visible-points/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window
 */
package com.idiotleon.leetcode.lvl4.lc1610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0Geometry {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;

        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);

            if (dx == 0 && dy == 0) {
                ++count;
                continue;
            }

            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }

        Collections.sort(angles);

        List<Double> padded = new ArrayList<>(angles);
        for (double ang : angles)
            padded.add(ang + 360);

        int most = count;
        int lo = 0, hi = 0;
        while (hi < padded.size()) {
            while (padded.get(hi) - padded.get(lo) > angle) {
                ++lo;
            }

            most = Math.max(most, count + hi - lo + 1);
            ++hi;
        }

        return most;
    }
}
