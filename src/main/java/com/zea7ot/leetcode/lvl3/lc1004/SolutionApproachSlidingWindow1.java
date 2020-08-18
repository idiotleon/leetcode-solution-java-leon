/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
package com.zea7ot.leetcode.lvl3.lc1004;

public class SolutionApproachSlidingWindow1 {
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0, max = 0;
        while(j < A.length){
            if(A[j] == 0) K--;
            j++;
            
            if(K < 0){
                while(A[i] != 0){
                    i++;
                }
                
                i++;
                K++;
            }
            
            max = Math.max(max, j - i);
        }
        
        return max;
    }
}