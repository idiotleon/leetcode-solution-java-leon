/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * 
 * References:
 *  https://leetcode.com/problems/angle-between-hands-of-a-clock/discuss/502738/JavaPythonC%2B%2B-Simple-Math-on-Clock-angles
 */
package com.zea7ot.lc.lvl2.lc1344;

public class SolutionAppraoch0Math {
    public double angleClock(int hour, int minutes) {
        double min = minutes * 6;
        double hr = hour * 30 + (double)minutes / 2;
        double angle = Math.abs(hr - min);
        return Math.min(angle, 360 - angle);
    }
}