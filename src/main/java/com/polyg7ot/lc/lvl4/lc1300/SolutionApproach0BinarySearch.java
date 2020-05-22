/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 * 
 * Time Complexity: O(N * lg(sum))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/463222/Java-Binary-search-O(nlogk)-k-is-the-max-value-in-arr
 */
package com.polyg7ot.lc.lvl4.lc1300;

public class SolutionApproach0BinarySearch {
    public int findBestValue(int[] arr, int target) {
        // sanity check
        if(arr == null || arr.length == 0) return 0;

        int max = Integer.MIN_VALUE, sum = 0;
        for(int num : arr){
            max = Math.max(max, num);
            sum += num;
        }
        
        if(target >= sum) return max;
        
        int diff = target, prevValue = max;
        
        int left = 0, right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            sum = getSum(arr, mid);
            int curDiff = Math.abs(target - sum);
            if(curDiff < diff){
                diff = curDiff;
                prevValue = mid;
            }else if(curDiff == diff){
                prevValue = Math.min(prevValue, mid);
            }
            
            if(target < sum){
                right = mid - 1; 
            }else{
                left = mid + 1;
            }
        }
        
        return prevValue;
    }
    
    private int getSum(int[] nums, int limit){
        int sum = 0;
        for(int num : nums){
            if(num > limit){
                sum += limit;
            }else{
                sum += num;
            }
        }
        
        return sum;
    }
}