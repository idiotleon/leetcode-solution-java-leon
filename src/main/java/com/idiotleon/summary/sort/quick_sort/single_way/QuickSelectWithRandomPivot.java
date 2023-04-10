/**
 * Time Complexity: 
 *  Best:       O(N)
 *  Average:    O(N)
 *  Worst:      O(N ^ 2)
 * 
 * `k` is 0-indexed
 */
package com.idiotleon.summary.sort.quick_sort.single_way;

import java.util.Random;

public class QuickSelectWithRandomPivot {
    public int quickSelect(int lo, int hi, int k, int[] nums){
        if(lo <= hi){
            int pivot = partition(lo, hi, nums);

            if(pivot == k) return nums[k];
            else if(pivot > k) return quickSelect(lo, pivot - 1, k, nums);
            else return quickSelect(pivot + 1, hi, k, nums);
        }
        
        return Integer.MIN_VALUE;
    }
    
    private int partition(int lo, int hi, int[] nums){
        int pivot = lo + new Random().nextInt(hi - lo + 1);
        swap(pivot, hi, nums);

        for(int idx = lo; idx < hi; ++idx){
            if(nums[idx] > nums[hi]){
                swap(lo, idx, nums);
                ++lo;
            }
        }

        swap(lo, hi, nums);
        return lo;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}