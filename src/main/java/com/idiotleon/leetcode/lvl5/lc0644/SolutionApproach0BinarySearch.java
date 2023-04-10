/**
 * https://leetcode.com/problems/maximum-average-subarray-ii/
 * 
 * Time Complexity: O(N * lg(max - min))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-average-subarray-ii/discuss/105480/Java-solution-O(nlogM)-Binary-search-the-answer/108078
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/maximum-average-subarray-i/
 */
package com.idiotleon.leetcode.lvl5.lc0644;

public class SolutionApproach0BinarySearch {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k || k <= 0) return Integer.MIN_VALUE;
        
        double min = nums[0], max = nums[0];
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        while(min <= max){
            double mid = min + (max - min) / 2.0;
            if(hasLargerAverage(nums, k, mid)){
                min = mid + 0.000_005;
            }else{
                max = mid - 0.000_005;
            }
        }
        
        return max;
    }
    
    private boolean hasLargerAverage(int[] nums, int k, double target){
        double curSum = 0, prevSum = 0;
        for(int i = 0; i < k; i++){
            curSum += nums[i] - target;
        }
        
        int idx = k;
        while(idx < nums.length){
            if(curSum >= 0) return true;
            curSum += nums[idx] - target;
            prevSum += nums[idx - k] - target;
            
            if(prevSum < 0){
                curSum -= prevSum;
                prevSum = 0;
            }
            
            idx++;
        }
        
        return curSum >= 0;
    }
}