/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl1.lc0977;

public class SolutionApproachTwoPtrs {
    public int[] sortedSquares(int[] A) {
        // sanity check
        if(A == null || A.length == 0) return new int[0];
        
        final int L = A.length;
        int[] ans = new int[L];
        
        int left = 0, right = L - 1, idx = L - 1;
        
        while(left <= right){
            if(Math.abs(A[left]) < Math.abs(A[right])){
                ans[idx--] = A[right] * A[right];
                right--;
            }else{
                ans[idx--] = A[left] * A[left];
                left++;
            }
        }
        
        return ans;
    }
}