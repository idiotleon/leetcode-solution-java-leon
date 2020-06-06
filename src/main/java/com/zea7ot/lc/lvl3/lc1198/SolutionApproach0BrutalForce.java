/**
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(10000) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-smallest-common-element-in-all-rows/discuss/387092/JavaC%2B%2BPython-Brute-Force-Count
 */
package com.zea7ot.lc.lvl3.lc1198;

public class SolutionApproach0BrutalForce {
    public int smallestCommonElement(int[][] mat) {
        int[] count = new int[10001];
        final int NR = mat.length, NC = mat[0].length;
        
        // to start with the smallest at the bottom row
        for(int col = 0; col < NC; col++){
            for(int row = 0; row < NR; row++){
                if(++count[mat[row][col]] == NR){
                    return mat[row][col];
                }
            }
        }
        
        return -1;
    }
}