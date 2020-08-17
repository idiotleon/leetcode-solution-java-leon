/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * 
 * Time Complexity:     O(M * lg(M)) + O(N * lg(N)) + O(M) + O(N) ~ O(max(M, N)lg(max(M, N)))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/discuss/661673/JavaPython-3-Find-the-max-width-and-height.
 */
package com.zea7ot.leetcode.lvl2.lv1465;

import java.util.Arrays;

public class SolutionApproach0OnePass {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int MOD = (int)1e9 + 7;
        final int M = horizontalCuts.length, N = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int maxGapH = Math.max(horizontalCuts[0], h - horizontalCuts[M - 1]);
        int maxGapV = Math.max(verticalCuts[0], w - verticalCuts[N - 1]);
        
        for(int i = 1; i < M; i++){
            maxGapH = Math.max(maxGapH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        for(int i = 1; i < N; i++){
            maxGapV = Math.max(maxGapV, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        // to prevent stackoverflow of the Integer type
        return (int) (1L * maxGapH * maxGapV % MOD);
    }
}