/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
package com.zea7ot.leetcode.lvl3.lc1004;

public class SolutionApproachSlidingWIndow {
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        while(j < A.length){
            if(A[j++] == 0) K--;
            if(K < 0 && A[i++] == 0) K++;
        }
        
        return j - i;
    }
}