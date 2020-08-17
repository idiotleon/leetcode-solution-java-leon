/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/discuss/451286/Java-Binary-Search/509023
 */
package com.zea7ot.leetcode.lvl2.lc1287;

import java.util.Arrays;
import java.util.List;

public class SolutionApproach0BinarySearch {
    public int findSpecialInteger(int[] nums) {
        final int N = nums.length;
        if(N == 1) return nums[0];
        
        List<Integer> list = Arrays.asList(nums[N / 4], nums[N / 2], nums[(3 * N) / 4]);
        for(int num : list){
            int idx = firstOccurrence(num, nums);
            if(nums[idx + N / 4] == num)
                return num;
        }
        
        return -1;
    }
    
    private int firstOccurrence(int target, int[] nums){
        final int N = nums.length;
        int lo = 0, hi = N - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(target > nums[mid])
                lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}