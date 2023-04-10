/**
 * https://leetcode.com/problems/maximum-average-subarray-ii/
 * 
 * Time Complexity: O(N * lg(20002))
 * Space Complexity: O(N)
 * 
 * (cum1 + cum2 + cum3 ... + cumj)/j ≥ mid 
 *  <=  (cum1 − mid) + (cum2 − mid) + (cum3 − mid) + ... + (cumj − mid) ≥ 0
 * cum[] stores (cum1 - mid), (cum2 - mid), (cum3 - mid), ..., (cumj - mid)
 * 
 * "prev" keeps track of cumulative sum in front of the current window. 
 * If "prev" is smaller than 0, 
 * the cumulative sum of current window, which equals to (cur - prev), 
 * becomes bigger, i.e., is more possible to be bigger than 0
 * 
 * References:
 *  https://leetcode.com/problems/maximum-average-subarray-ii/discuss/132164/Java-Clear-Code-using-Binary-Search-with-Detailed-Explanations
 */
package com.idiotleon.leetcode.lvl5.lc0644;

public class SolutionApproach0BinarySearch1 {
    public double findMaxAverage(int[] nums, int k) {
        double left = -10001, right = 10001;
        while(left <= right){
            double mid = left + (right - left) / 2.0;
            
            if(canFindLargerAverage(nums, k, mid)){
                left = mid + 0.000_005;
            }else{
                right = mid - 0.000_005;
            }
        }
        
        return left;
    }
    
    private boolean canFindLargerAverage(int[] nums, int k, double target){
        final int N = nums.length;
        
        double[] cum = new double[N];
        for(int i = 0; i < N; i++){
            cum[i] = nums[i] - target;
        }
        
        double cur = 0, prev = 0;
        for(int i = 0; i < k; i++){
            cur += cum[i];
        }
        
        if(cur >= 0) return true;
        
        for(int i = k; i < N; i++){
            cur += cum[i];
            prev += cum[i - k];
            
            if(prev < 0){
                cur -= prev;
                prev = 0;
            }
            
            if(cur >= 0) return true;
        }
        
        return false;
    }
}