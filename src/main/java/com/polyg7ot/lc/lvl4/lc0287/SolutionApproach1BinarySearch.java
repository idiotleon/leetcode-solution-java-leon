/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity: O(N ^ 2)
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-duplicate-number/discuss/72841/Java-O(1)space-using-Binary-Search
 */
package com.polyg7ot.lc.lvl4.lc0287;

public class SolutionApproach1BinarySearch {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        final int L = nums.length;
        
        int left = 0, right = L - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int num : nums){
                if(num <= mid) ++count;
            }
            
            if(count <= mid) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
}