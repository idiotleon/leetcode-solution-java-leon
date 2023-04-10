/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-duplicate-number/discuss/72841/Java-O(1)space-using-Binary-Search
 */
package com.idiotleon.leetcode.lvl4.lc0287;

public class SolutionApproach0Guess1 {
    public int findDuplicate(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        final int N = nums.length;
        
        int left = 0, right = N - 1;
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