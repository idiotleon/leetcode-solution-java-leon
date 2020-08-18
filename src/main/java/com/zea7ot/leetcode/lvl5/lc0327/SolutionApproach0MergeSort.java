/**
 * https://leetcode.com/problems/count-of-range-sum/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: 
 * 
 * References:
 *  https://leetcode.com/problems/count-of-range-sum/discuss/77990/Share-my-solution/82556
 */
package com.zea7ot.leetcode.lvl5.lc0327;

public class SolutionApproach0MergeSort {
    private int count = 0, lower, upper;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        final int L = nums.length;
        long[] sum = new long[L + 1];
        long[] temp = new long[L + 1];
        sum[0] = 0;
        
        this.lower = lower;
        this.upper = upper;
        
        for(int i = 1; i <= L; i++){
            sum[i] = sum[i - 1] + Long.valueOf(nums[i - 1]);
        }
        
        mergeSort(sum, 0, sum.length - 1, temp);
        return count;
    }
    
    private void mergeSort(long[] sum, int start, int end, long[] temp){
        if(start >= end) return;
        
        int mid = start + (end - start) / 2;
        mergeSort(sum, start, mid, temp);
        mergeSort(sum, mid + 1, end, temp);
        merge(sum, start, mid, end, temp);
    }
    
    private void merge(long[] sum, int start, int mid, int end, long[] temp){
        int startIdx = mid + 1, endIdx = mid + 1;
        for(int i = start; i <= mid; i++){
            while(startIdx <= end && sum[startIdx] - sum[i] < lower){
                startIdx++;
            }
            
            while(endIdx <= end && sum[endIdx] - sum[i] <= upper){
                endIdx++;
            }
            
            count += endIdx - startIdx;
        }
        
        int index = start;
        int tLeft = start, tRight = mid + 1;
        while(tLeft <= mid && tRight <= end){
            if(sum[tLeft] > sum[tRight]){
                temp[index++] = sum[tRight++];
            }else{
                temp[index++] = sum[tLeft++];
            }
        }
        
        while(tLeft <= mid){
            temp[index++] = sum[tLeft++];
        }
        
        while(tRight <= end){
            temp[index++] = sum[tRight++];
        }
        
        for(int i = start; i <= end; i++){
            sum[i] = temp[i];
        }
    }
}