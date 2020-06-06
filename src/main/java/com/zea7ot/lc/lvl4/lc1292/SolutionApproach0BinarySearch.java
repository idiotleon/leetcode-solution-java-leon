/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 * 
 * Time Complexity: O(NR * NC) + O(NR * NC * lg(min(NR, NC))) ~ O(NR * NC * lg(min(NR, NC)))
 * Space Complexity: O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/discuss/452478/Java-Prefix-sum-and-Binary-Search-Clean-code-O(m*n*log(min(mn))
 */
package com.zea7ot.lc.lvl4.lc1292;

public class SolutionApproach0BinarySearch {
    public int maxSideLength(int[][] matrix, int threshold) {
        final int NR = matrix.length, NC = matrix[0].length;
        
        int[][] prefixSum = new int[NR + 1][NC + 1];
        for(int row = 1; row <= NR; row++){
            for(int col = 1; col <= NC; col++){
                prefixSum[row][col] = matrix[row - 1][col - 1] + prefixSum[row - 1][col] + prefixSum[row][col - 1] - prefixSum[row - 1][col - 1];
            }
        }
        
        int left = 1, right = Math.min(NR, NC);
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(foundSquare(matrix, prefixSum, mid, threshold)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean foundSquare(int[][] matrix, int[][] prefixSum, int side, int threshold){
        final int NR = matrix.length, NC = matrix[0].length;
        
        for(int row = side; row <= NR; row++){
            for(int col = side; col <= NC; col++){
                if(prefixSum[row][col] - prefixSum[row - side][col] - prefixSum[row][col - side] + prefixSum[row - side][col - side] <= threshold) 
                    return true;
            }
        }
        
        return false;
    }
}