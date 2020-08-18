/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl1.lc0977;

public class SolutionApproachTwoPtr1 {
    public int[] sortedSquares(int[] A) {
		// sanity check
        if(A == null || A.length == 0) return new int[0];
        
        final int L = A.length;
        int[] ans = new int[L];
        
        int left = 0, right = 0, idx = 0;
        while(right < L && A[right] <= 0){
            right++;
        }
        
        left = right - 1;
        
        while(idx < L){
            if(left >= 0 && right < L){
                if(Math.abs(A[left]) > Math.abs(A[right])){
                    ans[idx++] = A[right] * A[right];
                    right++;
                }else{
                    ans[idx++] = A[left] * A[left];
                    left--;
                }
            }else if(left >= 0){
                ans[idx++] = A[left] * A[left];
                left--;
            }else{
                ans[idx++] = A[right] * A[right];
                right++;
            }
        }
        
        return ans;
    }
}