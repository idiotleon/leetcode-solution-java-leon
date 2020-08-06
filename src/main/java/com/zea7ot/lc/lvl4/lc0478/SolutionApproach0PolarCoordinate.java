/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/generate-random-point-in-a-circle/discuss/154037/Polar-Coordinates-10-lines
 *  https://meyavuz.wordpress.com/2018/11/15/generate-uniform-random-points-within-a-circle/
 *  http://www.anderswallin.net/2009/05/uniform-random-points-in-a-circle-using-polar-coordinates/
 */
package com.zea7ot.lc.lvl4.lc0478;

public class SolutionApproach0PolarCoordinate {
    private final double RADIUS, X_CENTER, Y_CENTER;

    public SolutionApproach0PolarCoordinate(double radius, double xCenter, double yCenter) {
        this.RADIUS = radius;
        this.X_CENTER = xCenter;
        this.Y_CENTER = yCenter;
    }
    
    public double[] randPoint() {
        final double LEN = Math.sqrt(Math.random()) * RADIUS;
        final double DEGREE = Math.random() * 2 * Math.PI;
        final double X = X_CENTER + LEN * Math.cos(DEGREE);
        final double Y = Y_CENTER + LEN * Math.sin(DEGREE);
        return new double[]{X, Y};
    }
}