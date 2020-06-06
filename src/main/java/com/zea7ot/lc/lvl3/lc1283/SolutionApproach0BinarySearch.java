/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * 
 * Time Complexity: O(N * lg(max(nums)))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/discuss/446376/JavaC%2B%2BPython-Binary-Search
 */
package com.zea7ot.lc.lvl3.lc1283;

public class SolutionApproach0BinarySearch {
    public int smallestDivisor(int[] nums, int threshold) {
        // sanity check
        if(nums == null || nums.length == 0 || threshold == 0) return 0;
                
        int left = 1, right = (int)1e6;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            int sum = getSum(nums, mid);
            if(sum > threshold){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private int getSum(int[] nums, int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (num + divisor - 1) / divisor;
        }
        
        return sum;
    }
}