/**
 * https://leetcode.com/problems/rectangle-area/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/rectangle-area/discuss/62138/My-Java-solution-Sum-of-areas-Overlapped-area
 *  https://leetcode.com/problems/rectangle-area/discuss/62257/An-explanation-in-plain-language
 */
package com.an7one.leetcode.lvl3.lc0223;

public class SolutionApproach0Geometry {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaRec1 = (C - A) * (D - B);
        int areaRec2 = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        // if overlapped
        int overlap = 0;
        if (right > left && top > bottom)
            overlap = (right - left) * (top - bottom);

        return areaRec1 + areaRec2 - overlap;
    }
}